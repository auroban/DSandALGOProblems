package dsandalgos.greedyalgos.primsminspanningtree;

import java.util.HashMap;
import java.util.Map;

public class Vertex {

    private final String label;
    private final Map<String, Edge> edges;

    public Vertex(final String label) {
        this.label = label;
        edges = new HashMap<>();
    }

    public String getLabel() {
        return label;
    }

    public Map<String, Edge> getEdges() {
        return edges;
    }

    public void addEdge(final String label, final Edge edge) {
        edges.put(label, edge);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                ", edges=" + edges +
                '}';
    }
}
