import os

benchmarks = {
    "butterknife" : "ButterKnife",
    "cache2k_cf" : "Cache2k-CF",
    "cache2k_nw" : "Cache2k-NW",
    "floating" : "FloatingActionButtonSpeedDial",
    "jib" : "Jib",
    "mealplanner" : "Meal-Planner",
    "nameless" : "Nameless",
    "picasso"  : "Picasso",
    "table_api" : "Table-wrapper-api",
    "table_csv" : "Table-wrapper-csv-impl",
}

def read_error_count(benchmark, checker, version):
    filename = f"{benchmark}_{version}_{checker}.txt"
    if os.path.exists(f"results/{filename}"):
        with open(f"results/{filename}", 'r') as f:
            lines = f.readlines()
            return lines[-1].strip()
    return "?"
    

print("Benchmark , CF PreV , CF PostV , NW PreV , NW PostV")    
for benchmark in benchmarks.keys():
    name = benchmarks[benchmark]
    nullness_pre = read_error_count(name, "nullness", "pre")
    nullness_post = read_error_count(name, "nullness", "post")
    nullaway_pre = read_error_count(name, "nullaway", "pre")
    nullaway_post = read_error_count(name, "nullaway", "post")
    print(f"{name} , {nullness_pre} , {nullness_post} , {nullaway_pre} , {nullaway_post}")
    

