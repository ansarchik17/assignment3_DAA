package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V; // количество вершин
    private final List<Edge> edges; // список всех рёбер
    private final List<List<Edge>> adj; // список смежности

    public Graph(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, double w) {
        Edge e = new Edge(u, v, w);
        edges.add(e);
        adj.get(u).add(e);
        adj.get(v).add(e); // неориентированный граф
    }

    public int getV() {
        return V;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<List<Edge>> getAdj() {
        return adj;
    }

    public int getE() {
        return edges.size();
    }
}