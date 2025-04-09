import os

root = "/home/nima/Developer/NJR-ANNOTATED-RUN/wpi"

# loop through all files in root and rename all .java with .ajava
for path, subdirs, files in os.walk(root):
    for name in files:
        if name.endswith('.java'):
            os.rename(os.path.join(path, name), os.path.join(path, name.replace('.java', '.ajava')))