import os
import re

def get_declared_package(java_file_path):
    """Extracts the declared package from a Java file."""
    with open(java_file_path, 'r', encoding='utf-8') as file:
        for line in file:
            line = line.strip()
            if line.startswith("package "):
                match = re.match(r'package\s+([a-zA-Z0-9_.]+);', line)
                if match:
                    return match.group(1)
    return None

def get_expected_package(root_dir, file_path):
    """Computes the expected package from the file's relative path."""
    relative_path = os.path.relpath(file_path, root_dir)
    dir_path = os.path.dirname(relative_path)
    # Convert path separators to dots
    return dir_path.replace(os.path.sep, '.')

def check_packages(root_dir):
    for dirpath, _, filenames in os.walk(root_dir):
        for filename in filenames:
            if filename.endswith(".java"):
                file_path = os.path.join(dirpath, filename)
                declared_package = get_declared_package(file_path)
                expected_package = get_expected_package(root_dir, file_path)
                expected_package = "org." + expected_package  # Add "org." prefix

                if declared_package is None:
                    print(f"[MISSING] No package declared in: {file_path}")
                elif declared_package != expected_package:
                    print(f"[MISMATCH] {file_path}")
                    print(f"  Declared: {declared_package}")
                    print(f"  Expected: {expected_package}")

if __name__ == "__main__":
    root = "."  # Change this to your root directory
    print(f"Checking packages in {root}...")
    check_packages(root)
