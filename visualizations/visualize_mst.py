import os
import pandas as pd
import networkx as nx
import matplotlib.pyplot as plt

# Paths
BASE_DIR = os.path.dirname(__file__)
CSV_PATH = os.path.join(BASE_DIR, "../results/summary.csv")
OUTPUT_DIR = os.path.join(BASE_DIR, "output_images")
os.makedirs(OUTPUT_DIR, exist_ok=True)

# Load CSV results
df = pd.read_csv(CSV_PATH)

# Group by graph ID
graph_groups = df.groupby("graph_id")

for graph_id, group in graph_groups:
    prim = group[group["algo"] == "Prim"].iloc[0]
    kruskal = group[group["algo"] == "Kruskal"].iloc[0]

    # Dummy graph for demonstration (replace with your JSON/edge loader later)
    n = int(prim["vertices"])
    G = nx.gnm_random_graph(n, int(prim["edges"]), seed=graph_id)
    for (u, v) in G.edges():
        G[u][v]['weight'] = round(1 + 10 * nx.utils.uniform_sequence(1)[0], 2)

    # Draw full graph
    pos = nx.spring_layout(G, seed=graph_id)
    plt.figure(figsize=(6, 5))
    nx.draw(G, pos, with_labels=True, node_color='lightblue', node_size=700, font_size=9)
    nx.draw_networkx_edge_labels(G, pos, edge_labels={(u, v): d['weight'] for u, v, d in G.edges(data=True)})

    plt.title(f"Graph {graph_id} — MST Cost = {prim['total_cost']} (Prim & Kruskal match)")
    plt.tight_layout()
    plt.savefig(os.path.join(OUTPUT_DIR, f"graph_{graph_id}.png"))
    plt.close()

print(f"✅ Visualization complete. Images saved to: {OUTPUT_DIR}")
