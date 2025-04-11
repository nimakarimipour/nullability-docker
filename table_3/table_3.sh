#!/bin/bash

# if fresh passed rerun nullaway.py
if [ "$1" == "--fresh" ]; then
    python3 nullaway.py
fi

# if fresh passed rerun nullness.py
if [ "$1" == "--fresh" ]; then
    python3 nullness.py
fi

python3 show.py