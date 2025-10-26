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

<img width="754" height="421" alt="Screenshot 2025-10-26 at 23 27 13" src="https://github.com/user-attachments/assets/12e1adb5-ec1e-49eb-999f-87b5a42b6777" />


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
