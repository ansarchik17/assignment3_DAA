package io;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GraphDataset {
    public List<GraphEntry> graphs;

    public static class GraphEntry {
        public int id;
        public List<String> nodes;
        public List<JsonEdge> edges;
    }

    public static class JsonEdge {
        public String from;
        public String to;

        @JsonProperty("weight")
        public int w;
    }
}