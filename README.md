Student: Ansar Keles
University: Astana IT University
Course: Algorithms and Data Structures
Date: October 2025

📘 Project Overview
This project implements Prim’s and Kruskal’s algorithms for finding the Minimum Spanning Tree (MST) of weighted graphs.
It simulates optimizing a city transportation network by minimizing road construction costs while keeping all points connected.

🌼 Project Structure
src/main/java/mst/ → Java source code
data/ → Input graph datasets (JSON)
results/ → Output results (JSON + CSV)
Assignment3_Report.pdf → Final report
pom.xml → Maven configuration file

⚙️ How to Run
Open the project in IntelliJ IDEA (as a Maven project)
Run the class: mst.Main
The program will generate:
results/output.json — detailed results
results/summary.csv — summary table
📊 Experimental Results
Graph	Algorithm	Total Cost	Time (ms)	Operations
smallGraph1	Prim	8	8	11
smallGraph1	Kruskal	8	2	33
mediumGraph1	Prim	43	0	30
mediumGraph1	Kruskal	43	0	114
largeGraph1	Prim	104	0	54
largeGraph1	Kruskal	104	0	252
🧠 Analysis
Both algorithms yield the same MST total cost → correctness confirmed ✅
Prim’s algorithm performs slightly faster on dense graphs.
Kruskal’s algorithm performs better on sparse graphs, though with more edge comparisons.
Complexities:

Prim — O(V²)
Kruskal — O(E log E)
