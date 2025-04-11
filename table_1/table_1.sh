#!/bin/bash

if [ "$1" == "fresh" ]; then
    #python3 nullaway.py

    pushd ./wpi-njr-debug > /dev/null
    ./run.sh
    popd > /dev/null

    mkdir -p ./results

    # Only copy if the source directory exists and is not empty
    if [ -d "wpi-njr-debug/results" ] && [ "$(ls -A wpi-njr-debug/results)" ]; then
        cp -r wpi-njr-debug/results/* ./results/
    else
        echo "No results to copy from wpi-njr-debug/results"
    fi
fi

#python3 show.py
