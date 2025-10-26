package io;

import java.util.List;

public class OutputRecord {
    public int graph_id;
    public InputStats input_stats;
    public AlgoResult prim;
    public AlgoResult kruskal;

    public static class InputStats {
        public int vertices;
        public int edges;
    }

    public static class AlgoResult {
        public double total_cost;
        public double execution_time_ms;
        public long operations_count;
        public List<EdgeRecord> mst_edges;
    }

    public static class EdgeRecord {
        public String from;
        public String to;
        public double weight;

        public EdgeRecord(String from, String to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}