# just parse .txt files and print the numbers of tables, create a .csv and print lines

# if fresh:
    # 1. rerun inference tools and store output in annotated_src
    # 2. rerun checker on base/[nullaway-nullness]
    # 3. rewrite __.txt file
    # 4. do all with non-fresh


!# /bin/bash

# if fresh passed rerun nullaway.py
if [ "$1" == "fresh" ]; then
    python3 nullaway.py
fi

# if fresh passed rerun nullness.py
if [ "$1" == "fresh" ]; then
    python3 nullness.py
fi

python3 show.py