import os
import shutil
import subprocess

BENCHMARKS_FOLDER = "../dataset"
RESULTS_FOLDER = "errorprone_results"
COMPILED_CLASSES_FOLDER = "ep_classes"
SRC_FILES = "ep_srcs.txt"
ERRORPRONE_DIR = "tools/error_prone"
ERRORPRONE_JARS = f'{ERRORPRONE_DIR}/error_prone_core-2.5.1-with-dependencies.jar:{ERRORPRONE_DIR}/dataflow-shaded-3.7.1.jar:{ERRORPRONE_DIR}/nullaway-0.10.10.jar'
ERRORPRONE_COMMAND = f"-J-Xbootclasspath/p:{ERRORPRONE_DIR}/javac-9+181-r4173-1.jar -XDcompilePolicy=simple -processorpath {ERRORPRONE_JARS} '-Xplugin:ErrorProne -XepDisableAllChecks -Xep:NullAway:ERROR -XepOpt:NullAway:AnnotatedPackages='"
SKIP_COMPLETED = False #skips if the output file is already there.
TIMEOUT = 1800
TIMEOUT_CMD = "timeout"

NULLAWAY_DIRS = os.listdir("errorprone_results")
CF_DIRS = os.listdir("checkerframework_results")

#Loop through the benchmarks
print("Completed Benchmarks")
i = 0
for benchmark in os.listdir(BENCHMARKS_FOLDER):
    if(not(benchmark + ".txt" in NULLAWAY_DIRS and benchmark + ".txt" in CF_DIRS)):
        continue
    
    nullaway_errors = open(f'errorprone_results/{benchmark}.txt', "r").readlines()
    cf_errors = open(f'checkerframework_results/{benchmark}.txt', "r").readlines()
    if(len(nullaway_errors) == 0 or len(cf_errors) == 0):
        continue
    nullaway_errors = nullaway_errors[-1][:nullaway_errors[-1].find("errors")-1]
    cf_errors = cf_errors[-1][:cf_errors[-1].find("errors")-1]
    
    command = ["cloc", "."]
    result = subprocess.run(command, stdout=subprocess.PIPE, text=True, cwd="/home/nima/Developer/NJR/dataset/" + benchmark + "/src")
    result = result.stdout.split("\n")
    result = [x for x in result if "Java" in x]
    result = result[0].split(" ")[-1]
    print(f'{benchmark},{result},{nullaway_errors},{cf_errors}')
