package io;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWriter {

    public static void writeJson(List<OutputRecord> records, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), new OutputWrapper(records));
    }

    public static void writeCsv(List<OutputRecord> records, String path) throws IOException {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write("graph_id,algo,total_cost,execution_time_ms,operations_count,vertices,edges\n");
            for (OutputRecord r : records) {
                fw.write(String.format(
                        "%d,Prim,%.4f,%.2f,%d,%d,%d\n",
                        r.graph_id, r.prim.total_cost, r.prim.execution_time_ms, r.prim.operations_count,
                        r.input_stats.vertices, r.input_stats.edges
                ));
                fw.write(String.format(
                        "%d,Kruskal,%.4f,%.2f,%d,%d,%d\n",
                        r.graph_id, r.kruskal.total_cost, r.kruskal.execution_time_ms, r.kruskal.operations_count,
                        r.input_stats.vertices, r.input_stats.edges
                ));
            }
        }
    }

    public static class OutputWrapper {
        public List<OutputRecord> results;

        public OutputWrapper(List<OutputRecord> results) {
            this.results = results;
        }
    }
}