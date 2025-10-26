package graph;

public class Edge {
    public final int u;      // одна вершина
    public final int v;      // другая вершина
    public final double w;   // вес (стоимость дороги)

    public Edge(int u, int v, double w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "(" + u + " - " + v + ", cost=" + w + ")";
    }
}