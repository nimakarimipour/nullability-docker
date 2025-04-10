#!/bin/bash
set -e

ROOT_DIR=$(pwd)

IS_FRESH=false
if [[ "$1" == "fresh" ]]; then
  IS_FRESH=true
  echo "Fresh run requested. Removing old project directories..."
  rm -rf "$ROOT_DIR/projects_for_annotation_counts_study"
  rm -rf "$ROOT_DIR/projects_for_diff_counts"
fi

echo ""
bash "$ROOT_DIR/run_annotation_counts_study.sh"
echo ""
bash "$ROOT_DIR/run_diff_categories_study.sh"
echo ""

if [[ "$IS_FRESH" == false ]]; then
  echo ""
  echo "Note: You ran this without 'fresh', so existing repositories were reused."
  echo "To freshly clone all repositories, run the script with: bash $0 fresh"
  echo ""
fi

echo "------------------------------------------------------------"
echo "All processing complete."
echo ""
echo "Diff files:                 $ROOT_DIR/results/diffs"
echo "Annotated diff files:       $ROOT_DIR/results/annotated_diffs"
echo "Annotation counts (post):   $ROOT_DIR/results/counts"
echo "Change category counts:     $ROOT_DIR/project_diff_categories_counts.csv"
echo ""
echo "To view the category summary, run:"
echo "    python3 scripts/show_results.py"
echo "------------------------------------------------------------"
