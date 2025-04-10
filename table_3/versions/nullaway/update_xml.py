import os
import xml.etree.ElementTree as ET

def update_path_in_xml(xml_path, new_path):
    tree = ET.parse(xml_path)
    root = tree.getroot()
    
    # Find and update <path> element
    path_elem = root.find("path")
    if path_elem is not None:
        path_elem.text = new_path
        tree.write(xml_path)
        print(f"Updated <path> in {xml_path}")
    else:
        print(f"No <path> element found in {xml_path}")

def process_annotator_out_dir(dirpath):
    zero_dir = os.path.join(dirpath, "0")
    scanner_xml = os.path.join(dirpath, "scanner.xml")
    nullaway_xml = os.path.join(dirpath, "nullaway.xml")

    if os.path.isdir(zero_dir) and os.path.isfile(scanner_xml) and os.path.isfile(nullaway_xml):
        abs_zero_path = os.path.abspath(zero_dir)
        update_path_in_xml(scanner_xml, abs_zero_path)
        update_path_in_xml(nullaway_xml, abs_zero_path)

def walk_and_process(base_dir):
    for root, dirs, files in os.walk(base_dir):
        if "annotator-out" in dirs:
            annotator_out_path = os.path.join(root, "annotator-out")
            process_annotator_out_dir(annotator_out_path)

if __name__ == "__main__":
    base_directory = "." 
    walk_and_process(base_directory)