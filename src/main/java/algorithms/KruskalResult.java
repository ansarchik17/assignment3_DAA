package algorithms;

import graph.Edge;
import java.util.List;

public class KruskalResult {
    public List<Edge> mstEdges;
    public double totalCost;
    public int vertexCount;
    public int edgeCount;
    public long operations;
    public double timeMs;

    public KruskalResult(List<Edge> edges, double cost, int v, int e, long ops, double time) {
        this.mstEdges = edges;
        this.totalCost = cost;
        this.vertexCount = v;
        this.edgeCount = e;
        this.operations = ops;
        this.timeMs = time;
    }
}