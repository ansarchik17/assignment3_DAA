# 🏙️ Assignment 3 — Minimum Spanning Tree (Prim & Kruskal)

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apache-maven)
![Algorithms](https://img.shields.io/badge/Algorithms-MST-success)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

**Student:** Ansar Keles  
**University:** Astana IT University  
**Course:** Design and Analytics of Algorithms  
**Date:** October 2025

---

## 📘 Project Overview
This project implements **Prim’s** and **Kruskal’s** algorithms for finding the **Minimum Spanning Tree (MST)** of weighted graphs.  
It simulates optimizing a **city transportation network** by minimizing road construction costs while keeping all points connected.

---

## 🌼 Project Structure
**src/main/java/** → Java source code  
**data/** → Input graph datasets (JSON)  
**results/** → Output results (JSON + CSV)  
**Assignment3_Report.pdf** → Final report  
**pom.xml** → Maven configuration file  

---

## ⚙️ How to Run
1. Open the project in **IntelliJ IDEA** (as a Maven project)
2. Run the class:
   mst.Main
3. The program will generate:
- `Assik3/ass_3_output.json` — detailed results
- `results/summary.csv` — summary table

---

## 📊 Experimental Results

graph_id,algo,total_cost,execution_time_ms,operations_count,vertices,edges
1,Prim,16.0000,1.52,57,5,7
1,Kruskal,16.0000,1.20,75,5,7
2,Prim,24.0000,0.03,67,6,8
2,Kruskal,24.0000,0.05,96,6,8
3,Prim,31.0000,0.03,91,8,10
3,Kruskal,31.0000,0.04,135,8,10
4,Prim,40.0000,0.04,93,9,10
4,Kruskal,40.0000,0.04,139,9,10
5,Prim,41.0000,0.03,107,10,11
5,Kruskal,41.0000,0.05,165,10,11

---

## 🧠 Analysis
- Both algorithms yield the **same MST total cost** → correctness confirmed ✅
- **Prim’s algorithm** performs slightly faster on dense graphs.
- **Kruskal’s algorithm** performs better on sparse graphs, though with more edge comparisons.

**Complexities:**
- Prim — `O(V²)`
- Kruskal — `O(E log E)`

---

## 📄 Final Report


## 🧾 References
- GeeksForGeeks — *Minimum Spanning Tree Algorithms*
- Cormen et al., *Introduction to Algorithms (CLRS, 3rd Edition)*
- Astana IT University course materials
