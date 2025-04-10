import os


names = {
    "butterknife" : "ButterKnife",
    "cache2k-cf" : "Cache2k-CF",
    "cache2k-nw" : "Cache2k-NW",
    "floating" : "FloatingActionButtonSpeedDial",
    "jib" : "Jib",
    "mealplanner" : "Meal-Planner",
    "nameless" : "Nameless",
    "picasso"  : "Picasso",
    "table-api" : "Table-wrapper-api",
    "table-csv" : "Table-wrapper-csv-impl",
}

def append_count_of_nullaway_errors(path):
    # start from last line stop at line with format regex "X errors" and extract the number
    num = 0
    with open(path, 'r') as f:
        lines = f.readlines()
        for line in lines[::-1]:
            if "errors" in line:
                num = line.split(" ")[0]
                break
    # append the number to the file
    with open(path, 'a') as f:
        f.write("{}\n".format(num))
                

for benchmark in names.keys():
    print(names[benchmark]) # Print the value
    # pre
    os.system("cd versions/nullaway/{}-pre/src && ./gradlew build -x test --rerun-tasks 2> /opt/table_1/results/{}_pre_nullaway.txt".format(benchmark, names[benchmark]))
    append_count_of_nullaway_errors("/opt/table_1/results/{}_pre_nullaway.txt".format(names[benchmark]))
    # post
    os.system("cd versions/nullaway/{}-post/src && ./gradlew build -x test --rerun-tasks 2> /opt/table_1/results/{}_post_nullaway.txt".format(benchmark, names[benchmark]))
    append_count_of_nullaway_errors("/opt/table_1/results/{}_post_nullaway.txt".format(names[benchmark]))