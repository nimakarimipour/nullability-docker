#!/bin/bash

# Find and delete all .git directories recursively
find . -type d -name ".git" -exec rm -rf {} +

echo "All .git directories have been removed."
