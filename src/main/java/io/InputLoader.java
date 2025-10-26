package io;

import com.fasterxml.jackson.databind.ObjectMapper;
import graph.Graph;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputLoader {

    public static GraphDataset loadDataset(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), GraphDataset.class);
    }

    public static Graph buildGraph(GraphDataset.GraphEntry entry, Map<String, Integer> nodeToIndex, Map<Integer, String> indexToNode) {
        nodeToIndex.clear();
        indexToNode.clear();
        int index = 0;
        for (String node : entry.nodes) {
            nodeToIndex.put(node, index);
            indexToNode.put(index, node);
            index++;
        }

        Graph g = new Graph(entry.nodes.size());
        for (GraphDataset.JsonEdge e : entry.edges) {
            int u = nodeToIndex.get(e.from);
            int v = nodeToIndex.get(e.to);
            g.addEdge(u, v, e.w);
        }
        return g;
    }
}