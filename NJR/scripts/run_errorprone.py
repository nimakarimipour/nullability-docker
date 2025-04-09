'''
This script runs error-prone on all the benchmarks.
Fill in the correct values for the macros at
the top of the file before executing.
'''
import os
import shutil
import subprocess
import time

CURRENT_DIR = os.path.dirname(os.path.realpath(__file__))
BENCHMARKS_FOLDER = "../original"
RESULTS_FOLDER = "errorprone_results"
COMPILED_CLASSES_FOLDER = "ep_classes"
SRC_FILES = "ep_srcs.txt"
ERRORPRONE_DIR = "tools/error_prone"
CHECKER_DIR = "tools/checker-framework-3.42.0"
ANNOTATOR_DIR = "tools/annotator"
ANNOTATOR_OUT = f"{CURRENT_DIR}/annotator-out"
ERRORPRONE_JARS = f'{ERRORPRONE_DIR}/error_prone_core-2.5.1-with-dependencies.jar:{ERRORPRONE_DIR}/dataflow-nullaway-3.26.0.jar:{ERRORPRONE_DIR}/nullaway-0.10.10.jar:{ANNOTATOR_DIR}/scanner.jar:{ANNOTATOR_DIR}/Expression.jar:{CHECKER_DIR}/checker/dist/checker-qual.jar'
ERRORPRONE_COMMAND = f"-XDcompilePolicy=simple -processorpath {ERRORPRONE_JARS} '-Xplugin:ErrorProne -XepDisableAllChecks -Xep:ExpSerializer:OFF -Xep:AnnotatorScanner:WARN -XepOpt:AnnotatorScanner:ConfigPath={ANNOTATOR_OUT}/scanner.xml -Xep:NullAway:ERROR -XepOpt:NullAway:SerializeFixMetadata=true -XepOpt:NullAway:FixSerializationConfigPath={ANNOTATOR_OUT}/checker.xml -XepOpt:NullAway:AnnotatedPackages="
SKIP_COMPLETED = False #skips if the output file is already there.
TIMEOUT = 1800
TIMEOUT_CMD = "timeout"
ANNOTATOR_JAR = f'{CURRENT_DIR}/{ANNOTATOR_DIR}/annotator.jar'

def prepare():
    shutil.rmtree(ANNOTATOR_OUT)
    os.makedirs(ANNOTATOR_OUT, exist_ok=True)
    with open(f'{ANNOTATOR_OUT}/paths.tsv', 'w') as o:
        o.write("{}\t{}\n".format(f'{ANNOTATOR_OUT}/checker.xml', f'{ANNOTATOR_OUT}/scanner.xml'))

#create the output folder if it doesn't exist
if not os.path.exists(RESULTS_FOLDER):
    os.mkdir(RESULTS_FOLDER)

broken = []
# read content of broken.txt
with open('broken.txt', 'r') as file:
    broken = file.read().splitlines()

#Loop through the benchmarks
print("Completed Benchmarks")
for benchmark in os.listdir(BENCHMARKS_FOLDER):
    if benchmark in broken:
        print(f"Skipping broken benchmark: {benchmark}")
        continue
    print("working on: " + benchmark)
    if (SKIP_COMPLETED):
        if os.path.exists(f'{RESULTS_FOLDER}/{benchmark}-after.txt'):
            print("skipping completed benchmark.")
            continue
    #skip non-directories
    if not os.path.isdir(f'{BENCHMARKS_FOLDER}/{benchmark}'):
        continue
    
    #create a folder for the compiled classes if it doesn't exist
    if not os.path.exists(COMPILED_CLASSES_FOLDER):
        os.mkdir(COMPILED_CLASSES_FOLDER)

    #Get a list of Java source code files.
    find_srcs_command = f'find {BENCHMARKS_FOLDER}/{benchmark}/src -name "*.java" > {SRC_FILES}'
    os.system(find_srcs_command)

    src = open(f'{BENCHMARKS_FOLDER}/{benchmark}/info/sources', "r").readlines()
    src = [x.strip() for x in src]
    src = [x[4:x.rfind("/")] for x in src]
    src = [x.replace("/", ".") for x in src]
    src = set(src)
    if '' in src:
        src.remove('')
    src = ",".join(src)
    if(src == ""):
        continue

    #get folder with libraries used by benchmark
    lib_folder = f'{BENCHMARKS_FOLDER}/{benchmark}/lib'

    # #build source files
    # build_command_before = (TIMEOUT_CMD 
    #     + " " + str(TIMEOUT)
    #     + " " + "javac -d"
    #     + " " + COMPILED_CLASSES_FOLDER
    #     + " " + " -cp " + lib_folder + f":{ERRORPRONE_DIR}/nullaway-annotations-0.10.22.jar:{ERRORPRONE_DIR}/jsr305-3.0.1.jar" 
    #     + " " + ERRORPRONE_COMMAND + src + "'"
    #     + " " + "-Xmaxerrs 10000"
    #     + " " + "-J-Xmx32G"
    #     + " @" + SRC_FILES
    #     + " 2> " +  RESULTS_FOLDER
    #     + "/" + benchmark + "-before.txt"
    # )
    # os.system(build_command_before)

    # build_command = (TIMEOUT_CMD 
    #     + " " + str(TIMEOUT)
    #     + " " + "javac -d"
    #     + " " + COMPILED_CLASSES_FOLDER
    #     + " " + " -cp " + lib_folder + f":{ERRORPRONE_DIR}/nullaway-annotations-0.10.22.jar:{ERRORPRONE_DIR}/jsr305-3.0.1.jar" 
    #     + " " + ERRORPRONE_COMMAND + src + "'"
    #     + " " + "-Xmaxerrs 10000"
    #     + " " + "-J-Xmx32G"
    #     + " @" + SRC_FILES
    # )

    # prepare()

    # commands = []
    # commands += ["java", "-jar", ANNOTATOR_JAR]
    # commands += ['-d', ANNOTATOR_OUT]
    # commands += ['-bc', f'{build_command}']
    # commands += ['-cp', f'{ANNOTATOR_OUT}/paths.tsv']
    # commands += ['-i', 'com.uber.nullaway.annotations.Initializer']
    # commands += ['-n', 'javax.annotation.Nullable']
    # commands += ['-cn', 'NULLAWAY']
    # commands += ["--depth", "10"]
    # start = time.time()
    # subprocess.call(commands)
    # elapsed_time = time.time() - start


    #build again
    build_command = (TIMEOUT_CMD 
        + " " + str(TIMEOUT)
        + " " + "javac -d"
        + " " + COMPILED_CLASSES_FOLDER
        + " " + " -cp " + lib_folder + f":{ERRORPRONE_DIR}/nullaway-annotations-0.10.22.jar:{ERRORPRONE_DIR}/jsr305-3.0.1.jar" 
        + " " + ERRORPRONE_COMMAND + src + "'"
        + " " + "-Xmaxerrs 10000" 
        + " " + "-J-Xmx32G"
        + " @" + SRC_FILES
        + " 2> " +  RESULTS_FOLDER
        + "/" + benchmark + "-after.txt"
    )
    os.system(build_command)
    scanner_out_path = "/home/nima/Developer/NJR-ANNOTATED-RUN/scripts/annotator-out/0"
    copy_path = "/home/nima/Developer/NJR-ANNOTATED-RUN/scripts/scanner_out/{}".format(benchmark)
    copy_command = "cp -r {} {}".format(scanner_out_path, copy_path)
    print("moving scanner output")
    os.system(copy_command)

    # #remove the classes folder
    # shutil.rmtree(COMPILED_CLASSES_FOLDER)

    # with open('time-1.txt', 'a') as o:
    #     o.write(f'{benchmark}\t{elapsed_time}\n')
    # print("done working on: " + benchmark)
print("All benchmarks completed")