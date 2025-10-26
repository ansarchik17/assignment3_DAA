import algorithms.*;
import io.*;
import graph.Edge;
import graph.Graph;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<OutputRecord.EdgeRecord> edgeListToRecords(List<Edge> edges, Map<Integer, String> indexToNode) {
        List<OutputRecord.EdgeRecord> res = new ArrayList<>();
        for (Edge e : edges) {
            String from = indexToNode.get(e.u);
            String to = indexToNode.get(e.v);
            res.add(new OutputRecord.EdgeRecord(from, to, e.w));
        }
        return res;
    }

    private static OutputRecord.AlgoResult fromPrim(PrimResult pr, Map<Integer, String> indexToNode) {
        OutputRecord.AlgoResult a = new OutputRecord.AlgoResult();
        a.total_cost = pr.totalCost;
        a.execution_time_ms = pr.timeMs;
        a.operations_count = pr.operations;
        a.mst_edges = edgeListToRecords(pr.mstEdges, indexToNode);
        return a;
    }

    private static OutputRecord.AlgoResult fromKruskal(KruskalResult kr, Map<Integer, String> indexToNode) {
        OutputRecord.AlgoResult a = new OutputRecord.AlgoResult();
        a.total_cost = kr.totalCost;
        a.execution_time_ms = kr.timeMs;
        a.operations_count = kr.operations;
        a.mst_edges = edgeListToRecords(kr.mstEdges, indexToNode);
        return a;
    }

    public static void main(String[] args) throws IOException {
        String[] inputFiles = {"data/ass_3_input.json"};
        List<OutputRecord> allRecords = new ArrayList<>();
        Map<String, Integer> nodeToIndex = new HashMap<>();
        Map<Integer, String> indexToNode = new HashMap<>();

        for (String path : inputFiles) {
            GraphDataset dataset = InputLoader.loadDataset(path);

            for (GraphDataset.GraphEntry entry : dataset.graphs) {
                Graph g = InputLoader.buildGraph(entry, nodeToIndex, indexToNode);

                long primStart = System.nanoTime();
                PrimResult pr = Prim.run(g);
                long primEnd = System.nanoTime();
                pr.timeMs = (primEnd - primStart) / 1_000_000.0;

                long kruskalStart = System.nanoTime();
                KruskalResult kr = Kruskal.run(g);
                long kruskalEnd = System.nanoTime();
                kr.timeMs = (kruskalEnd - kruskalStart) / 1_000_000.0;

                OutputRecord r = new OutputRecord();
                r.graph_id = entry.id;
                r.input_stats = new OutputRecord.InputStats();
                r.input_stats.vertices = g.getV();
                r.input_stats.edges = g.getE();
                r.prim = fromPrim(pr, indexToNode);
                r.kruskal = fromKruskal(kr, indexToNode);
                allRecords.add(r);
            }
        }

        OutputWriter.writeJson(allRecords, "ass_3_output.json");
        OutputWriter.writeCsv(allRecords, "results/summary.csv");

        System.out.println("Done. Results saved in ass_3_output.json and results/summary.csv");
    }
}