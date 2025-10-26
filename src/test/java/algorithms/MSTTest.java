package algorithms;

import graph.Edge;
import graph.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MSTTest {

    /** Create a small connected graph with 4 vertices */
    private Graph createSmallGraph() {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 3, 3);
        g.addEdge(1, 3, 5);
        return g;
    }

    /** Create a disconnected graph (no full MST exists) */
    private Graph createDisconnectedGraph() {
        Graph g = new Graph(3);
        g.addEdge(0, 1, 1); // vertex 2 is isolated
        return g;
    }

    @Test
    void primAndKruskalSameCostAndEdgeCount() {
        Graph g = createSmallGraph();
        PrimResult p = Prim.run(g);
        KruskalResult k = Kruskal.run(g);

        // Both should yield same MST total cost
        assertEquals(p.totalCost, k.totalCost, 1e-9, "Total cost must match");

        // MST must have V-1 edges
        assertEquals(g.getV() - 1, p.mstEdges.size(), "Prim MST should have V-1 edges");
        assertEquals(g.getV() - 1, k.mstEdges.size(), "Kruskal MST should have V-1 edges");
    }

    @Test
    void disconnectedGraphHandled() {
        Graph g = createDisconnectedGraph();
        PrimResult p = Prim.run(g);
        KruskalResult k = Kruskal.run(g);

        // Disconnected graph => MST cannot have V-1 edges
        assertNotEquals(g.getV() - 1, p.mstEdges.size(), "Prim MST should not have V-1 edges for disconnected graph");
        assertNotEquals(g.getV() - 1, k.mstEdges.size(), "Kruskal MST should not have V-1 edges for disconnected graph");
    }

    @Test
    void performanceMetricsNonNegative() {
        Graph g = createSmallGraph();
        PrimResult p = Prim.run(g);
        KruskalResult k = Kruskal.run(g);

        assertTrue(p.timeMs >= 0, "Prim execution time must be non-negative");
        assertTrue(p.operations >= 0, "Prim operations count must be non-negative");

        assertTrue(k.timeMs >= 0, "Kruskal execution time must be non-negative");
        assertTrue(k.operations >= 0, "Kruskal operations count must be non-negative");
    }

    @Test
    void resultIsAcyclicAndConnected() {
        Graph g = createSmallGraph();
        PrimResult p = Prim.run(g);

        // MST must have exactly V-1 edges
        assertEquals(g.getV() - 1, p.mstEdges.size(), "MST should have V-1 edges");

        // Ensure all vertices are reachable
        boolean[] visited = new boolean[g.getV()];
        dfs(p, 0, visited);

        for (int i = 0; i < g.getV(); i++) {
            assertTrue(visited[i], "Vertex " + i + " should be connected in MST");
        }
    }

    /** Helper DFS to test MST connectivity */
    private void dfs(PrimResult p, int u, boolean[] visited) {
        visited[u] = true;
        for (Edge e : p.mstEdges) {
            if (e.u == u && !visited[e.v]) dfs(p, e.v, visited);
            if (e.v == u && !visited[e.u]) dfs(p, e.u, visited);
        }
    }
}
