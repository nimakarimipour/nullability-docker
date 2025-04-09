import os
import subprocess
import re
import sys

DAIKON_EXECUTION_OUTPUT = "daikon_execution_results"
TRACES_DIR = "traces"
JAVA_COMMAND = "java"
TIMEOUT = 100
FILE_WITH_MAIN_CLASS = "info/mainclassname"
CUR_DIR = os.getcwd()
NJR = os.getenv("NJR")
BENCHMARKS_FOLDER = os.path.join(NJR, "original")
DAIKONDIR = os.getenv("DAIKONDIR")

# Function to execute a command with a timeout
def execute(command):
    try:
        result = subprocess.run(
            command,
            timeout=TIMEOUT,
            check=True,
            shell=True,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
            cwd=os.getcwd(),
        )
    except subprocess.TimeoutExpired:
        return
    except subprocess.CalledProcessError as e:
        return

def get_from_physical(benchmark, tool):
    path = f"annotations/{tool}/" + benchmark + ".tsv"
    if not os.path.exists(path):
        return []
    lines = open(path, "r").readlines()[1:]
    lines = [x[:x.index("/home/nima/") - 1].strip() for x in lines]
    lines = [x.replace("$", ".") for x in lines]
    return lines

def compute_missed_annotations_for(tool):
    trace_dir = os.path.join(CUR_DIR, TRACES_DIR)
    incompatible = open("incompatible.txt").readlines()
    incompatible = [x.strip() for x in incompatible]
    missed = 0
    # read traces annot
    for dirpath, _, filenames in os.walk(trace_dir):
        if(os.path.exists(dirpath + "/serialized.txt") == False):
            continue
        from_trace = set(open(dirpath + "/" + "serialized.txt").readlines())
        from_trace = [x.strip() for x in from_trace]
        from_trace = [x.replace("$", ".") for x in from_trace]
        if len(from_trace) == 0:
            continue
        from_trace = set([x.strip() for x in from_trace])
        benchmark = dirpath.split("/")[-1]
        if benchmark in incompatible:
            continue
        from_physical = set(get_from_physical(benchmark, tool))
        diff = from_trace - from_physical
        if len(diff) > 0:
            missed += len(diff)
    return missed

class TraceParser:
    def get_enclosing(self, lines, index):
        while index > 0:
            line = lines[index]
            if ":::" in line:
                if not (":::EXIT" in line):
                    return None
                line = line[:line.index(":::")]
                line = line.strip()
                # remove all whitespace
                line = re.sub(r'\s+', '', line)
                return re.sub(r'\d+$', '', line)
            index -= 1

    def extract_class_and_method(self, s):
        # Define the regex pattern to capture class name and method signature
        pattern = r'^(.*)\.(\w+)\((.*)\)$'
        match = re.match(pattern, s)
        if match:
            class_name = match.group(1)
            method_name = match.group(2)
            method_signature = match.group(3)
            return class_name, method_name + "(" + method_signature + ")"
        else:
            return None, None

    def parse(self, benchmark):
        benchmark_trace_path = os.path.join(
            CUR_DIR, TRACES_DIR, benchmark
        )
        benchmark_expression_path = os.path.join(
            CUR_DIR, "expressions", benchmark + ".tsv"
        )
        trace = [l.strip() for l in open(benchmark_trace_path + "/trace.txt").readlines()]
        if not os.path.exists(benchmark_expression_path):
            return
        exp_locations = [l.strip() for l in open(benchmark_expression_path).readlines()][1:]
        decls = {}
        for l in exp_locations:
            info = l.split("#$@$#")
            if len(info) < 4:
                continue
            clazz = info[0]
            method = info[1]
            exp = info[2]
            loc = info[3]
            block = clazz + "." + method
            if block not in decls:
                decls[block] = {}
            if exp not in decls[block]:
                decls[block][exp] = loc
        to_write = []
        for index, line in enumerate(trace):
            if line.endswith("== null"):
                enclosing = self.get_enclosing(trace, index)
                # skip enclosing that are not in methods
                if enclosing is None:
                    continue
                exp = line[:line.index("== null")].strip()
                if exp == "return":
                    clazz, method = self.extract_class_and_method(enclosing)
                    if clazz is None or method is None:
                        continue
                    to_write.append("METHOD\t" + clazz + "\t" + method + "\tnull\tnull")
                    continue
                else:
                    if enclosing not in decls:
                        continue
                    if exp not in decls[enclosing]:
                        continue
                    location = decls[enclosing][exp]
                    location = location[:location.index("/home/nima/") - 1]
                    to_write.append(location)
        with open(benchmark_trace_path + "/serialized.txt", "w") as f:
            if len(to_write) == 0:
                return
            to_write = list(set(to_write))
            print("extracted nullable locations: " + str(len(to_write)))
            for l in to_write:
                f.write(l + "\n")

def run_daikon_on_njr_benchmarks():
    print("Running daikon on njr benchmarks")
    # create the output folder if it doesn't exist
    results_folder_path = os.path.join(CUR_DIR, DAIKON_EXECUTION_OUTPUT)
    if not os.path.exists(results_folder_path):
        os.mkdir(results_folder_path)

    # Loop through the benchmarks
    print("Processing benchmarks...")
    for benchmark in os.listdir(BENCHMARKS_FOLDER):
        benchmark_results_folder = os.path.join(results_folder_path, benchmark)
        os.makedirs(benchmark_results_folder, exist_ok=True)

        if os.path.exists(os.path.join(benchmark_results_folder, "3.txt")):
            print("Already processed")
            continue
        print("Processing Benchmark: " + benchmark)

        # # skip non-directories
        benchmark_path = os.path.join(BENCHMARKS_FOLDER, benchmark)
        # Get jar file
        jarfile = ""
        for file in os.listdir(os.path.join(benchmark_path, "jarfile")):
            if file.endswith(".jar"):
                jarfile = file
        jarfile_path = os.path.join(benchmark_path, ("jarfile/" + jarfile))
        # get main class name
        mainclassname_file = os.path.join(benchmark_path, FILE_WITH_MAIN_CLASS)
        with open(mainclassname_file) as fp:
            mainclass_name = fp.read().splitlines()[0]

        execute("killall -9 java")

        run_command = (
            JAVA_COMMAND
            + " -cp "
            + jarfile_path
            + " "
            + mainclass_name
            + " > "
            + benchmark_results_folder
            + "/0.txt 2>&1"
        )
        print("Execting benchmark...")
        execute(run_command)

        run_command = (
            JAVA_COMMAND
            + " -cp "
            + jarfile_path
            + ":{}/daikon.jar".format(DAIKONDIR)
            + " "
            + "daikon.DynComp"
            + " "
            + mainclass_name
            + " > "
            + benchmark_results_folder
            + "/1.txt 2>&1"
        )
        print('Executing DynComp...')
        execute(run_command)

        run_command = (
            JAVA_COMMAND
            + " -cp "
            + jarfile_path
            + ":{}/daikon.jar".format(DAIKONDIR)
            + " "
            + "daikon.Chicory --comparability-file="
            + mainclass_name.split(".")[-1]
            + ".decls-DynComp"
            + " "
            + mainclass_name
            + " > "
            + benchmark_results_folder
            + "/2.txt 2>&1 "
        )
        print('Executing Chicory...')
        execute(run_command)

        run_command = (
            JAVA_COMMAND
            + " -cp "
            + jarfile_path
            + ":{}/daikon.jar".format(DAIKONDIR)
            + " "
            + "daikon.Daikon "
            + mainclass_name.split(".")[-1]
            + ".dtrace.gz"
            + " > "
            + benchmark_results_folder
            + "/3.txt 2>&1 "
        )
        print('Executing Daikon...')
        execute(run_command)

        execute("mv *.dtrace.gz {}".format(benchmark_results_folder))
        execute("mv *.decls-DynComp {}".format(benchmark_results_folder))
        print("Benchmark processed")

    print("All benchmarks processed.")
    print("Collecting traces...")
    for dirpath, dirnames, filenames in os.walk(DAIKON_EXECUTION_OUTPUT):
        out_3 = dirpath + "/3.txt"
        # check if out_3 exists
        if os.path.exists(out_3):
            print("Trace found for benchmark: " + dirpath)
            # read out_3
            with open(out_3, "r") as f:
                content = f.read()
                if ":::ENTER" in content:
                    benchmark = dirpath.split("/")[-1]
                    decl = ""
                    for name in filenames:
                        if name.endswith(".decls-DynComp"):
                            decl = name
                    if decl == "":
                        print("No decl file found in " + dirpath)
                        continue
                    benchmark_trace_path = os.path.join(
                        CUR_DIR, TRACES_DIR, benchmark
                    )
                    os.makedirs(benchmark_trace_path, exist_ok=True)
                    os.system(
                        "cp " + dirpath + "/" + decl + " " + benchmark_trace_path + "/decl-DynComp.txt")
                    os.system(
                        "cp " + dirpath + "/3.txt" + " " + benchmark_trace_path + "/trace.txt")
    print("All traces collected.")

def compute_missed_annotation_rates():
    trace_dir = os.path.join(CUR_DIR, TRACES_DIR)
    print("extracting nullable locations for all benchmarks")
    for dirpath, _, _ in os.walk(trace_dir):
        if dirpath == trace_dir:
            continue
        benchmark = dirpath.split("/")[-1]
        print("processing: " + benchmark)
        parser = TraceParser()
        parser.parse(benchmark)
    print("All nullable locations extracted.")
    print("Computing missed annotations for all tools")
    annotator_missed = compute_missed_annotations_for("annotator")
    print("number of missed annotations for annotator: " + str(annotator_missed))
    nullgtn_missed = compute_missed_annotations_for("nullgtn")
    print("number of missed annotations for nullgtn: " + str(nullgtn_missed))
    wpi_missed = compute_missed_annotations_for("wpi")
    print("number of missed annotations for wpi: " + str(wpi_missed))

    print("Percentages:")
    total = 312
    print("annotator:" + str(((total - annotator_missed) / total * 1.0) * 100) + "%")
    print("nullgtn: " + str(((total - nullgtn_missed) / total * 1.0) * 100) + "%")
    print("wpi: " + str(((total - wpi_missed) / total * 1.0) * 100) + "%")


if __name__ == "__main__":
    args = sys.argv[1:]
    if len(args) == 1 and args[0] == "--fresh":
        print("Requested fresh run of daikon")
        run_daikon_on_njr_benchmarks()
    compute_missed_annotation_rates()




