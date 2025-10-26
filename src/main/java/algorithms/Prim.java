package algorithms;

import graph.Edge;
import graph.Graph;
import util.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

    private static class PQItem {
        int vertex;
        double weight;
        PQItem(int vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static PrimResult run(Graph g) {
        Timer timer = new Timer();
        timer.start();

        int n = g.getV();
        List<Edge> mstEdges = new ArrayList<>();
        double totalCost = 0.0;
        long operations = 0;

        if (n == 0) {
            return new PrimResult(mstEdges, totalCost, n, g.getE(), operations, timer.elapsedMillis());
        }

        boolean[] inMST = new boolean[n];
        PriorityQueue<PQItem> pq = new PriorityQueue<>((a, b) -> Double.compare(a.weight, b.weight));
        operations++;

        // Start from vertex 0
        inMST[0] = true;
        for (Edge e : g.getAdj().get(0)) {
            int to = (e.u == 0) ? e.v : e.u;
            pq.offer(new PQItem(to, e.w));
            operations += 2;
        }
        operations += g.getAdj().get(0).size();

        while (!pq.isEmpty() && mstEdges.size() < n - 1) {
            PQItem item = pq.poll();
            operations += 3;
            if (inMST[item.vertex]) {
                operations++;
                continue;
            }

            inMST[item.vertex] = true;
            int from = -1;
            for (Edge e : g.getEdges()) {
                if ((e.u == item.vertex && inMST[e.v]) || (e.v == item.vertex && inMST[e.u])) {
                    from = inMST[e.u] ? e.u : e.v;
                    break;
                }
            }
            if (from != -1) {
                mstEdges.add(new Edge(from, item.vertex, item.weight));
                totalCost += item.weight;
                operations += 3;
            }

            for (Edge e : g.getAdj().get(item.vertex)) {
                int to = (e.u == item.vertex) ? e.v : e.u;
                if (!inMST[to]) {
                    pq.offer(new PQItem(to, e.w));
                    operations += 2;
                }
                operations++;
            }
        }

        return new PrimResult(mstEdges, totalCost, g.getV(), g.getE(), operations, timer.elapsedMillis());
    }
}