import graph.Edge;
import algorithms.Prim;
import graph.Graph;
import algorithms.Kruskal;
import algorithms.PrimResult;
import algorithms.KruskalResult;

public class DesignedGraphDemo {

    public static void main(String[] args) {
        // создаём граф вручную
        Graph g = new Graph(5);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 1);
        g.addEdge(1, 3, 4);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 4, 5);

        // выводим рёбра графа
        System.out.println("Graph edges:");
        for (Edge e : g.getEdges()) {
            System.out.println(e.u + " - " + e.v + " (" + e.w + ")");
        }

        // запускаем алгоритмы
        PrimResult prim = Prim.run(g);
        KruskalResult kruskal = Kruskal.run(g);

        // выводим результаты
        System.out.println("\n=== Designed Graph Results ===");
        System.out.println("Prim total cost: " + prim.totalCost);
        System.out.println("Kruskal total cost: " + kruskal.totalCost);

        // проверка корректности
        if (prim.totalCost == kruskal.totalCost) {
            System.out.println("Both algorithms produced identical MST costs.");
        } else {
            System.out.println(" Different MST costs — check implementation!");
        }
    }
}