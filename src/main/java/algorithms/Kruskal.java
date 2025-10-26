package algorithms;

import graph.Edge;
import graph.Graph;
import util.DisjointSetUnion;
import util.Timer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Kruskal {

    public static KruskalResult run(Graph g) {
        Timer timer = new Timer();
        timer.start();

        int n = g.getV();
        List<Edge> edges = new ArrayList<>(g.getEdges());
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        List<Edge> mstEdges = new ArrayList<>();
        double totalCost = 0.0;
        AtomicLong operations = new AtomicLong();

        operations.getAndIncrement();
        Collections.sort(edges, (a, b) -> {
            operations.getAndIncrement();
            return Double.compare(a.w, b.w);
        });
        operations.addAndGet(edges.size());

        operations.getAndIncrement();
        for (Edge e : edges) {
            operations.getAndIncrement();
            int ru = dsu.find(e.u);
            int rv = dsu.find(e.v);

            if (ru != rv) {
                operations.getAndIncrement();
                if (dsu.union(ru, rv)) {
                    mstEdges.add(e);
                    totalCost += e.w;
                    operations.addAndGet(2);
                    if (mstEdges.size() == n - 1) {
                        operations.getAndIncrement();
                        break;
                    }
                }
            }
        }

        operations.addAndGet(dsu.totalOps());

        return new KruskalResult(mstEdges, totalCost, g.getV(), g.getE(), operations.get(), timer.elapsedMillis());
    }
}