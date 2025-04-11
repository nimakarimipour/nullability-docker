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

def read_error_count(benchmark, checker, version, tool):
    filename = f"{benchmark}_{version}_{checker}_{tool}.txt"
    if os.path.exists(f"results/{filename}"):
        with open(f"results/{filename}", 'r') as f:
            lines = f.readlines()
            return lines[-1].strip()
    return "?"
    

print("Benchmark, WPI-CF-Pre, WPI-CF-Post, WPI-NW-Pre, WPI-NW-Post, ANN-CF-Pre, ANN-CF-Post, ANN-NW-Pre, ANN-NW-Post", "NGT-CF-Pre, NGT-CF-Post, NGT-NW-Pre, NGT-NW-Post")
 
for benchmark in benchmarks.keys():
    name = benchmarks[benchmark]
    
    # ann for annotator
    nullness_pre_ann = read_error_count(name, "nullness", "pre", "ann")
    nullness_post_ann = read_error_count(name, "nullness", "post", "ann")
    nullaway_pre_ann = read_error_count(name, "nullaway", "pre", "ann")
    nullaway_post_ann = read_error_count(name, "nullaway", "post", "ann")
    
    # wpi for wpi
    nullness_pre_wpi = read_error_count(name, "nullness", "pre", "wpi")
    nullness_post_wpi = read_error_count(name, "nullness", "post", "wpi")
    nullaway_pre_wpi = read_error_count(name, "nullaway", "pre", "wpi")
    nullaway_post_wpi = read_error_count(name, "nullaway", "post", "wpi")
    
    # ngt for nullgtn
    nullness_pre_ngt = read_error_count(name, "nullness", "pre", "ngt")
    nullness_post_ngt = read_error_count(name, "nullness", "post", "ngt")
    nullaway_pre_ngt = read_error_count(name, "nullaway", "pre", "ngt")
    nullaway_post_ngt = read_error_count(name, "nullaway", "post", "ngt")
    
    print(f"{name}, {nullness_pre_wpi}, {nullness_post_wpi}, {nullaway_pre_wpi}, {nullaway_post_wpi}, {nullness_pre_ann}, {nullness_post_ann}, {nullaway_pre_ann}, {nullaway_post_ann}, {nullness_pre_ngt}, {nullness_post_ngt}, {nullaway_pre_ngt}, {nullaway_post_ngt}")
    
    
    
    
    

