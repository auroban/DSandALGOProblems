package dsandalgos.greedyalgos.primsminspanningtree;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

public class PrimsMST {

    private static final Logger LOGGER = Logger.getLogger(PrimsMST.class.getSimpleName());

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        private Pair(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public boolean isEmpty() {
            return (key == null && value == null);
        }
    }

    public static String convertToString(final List<Vertex> mst) {
        final StringBuilder stringBuilder = new StringBuilder();
        if (!mst.isEmpty()) {
            mst.forEach((vertex) -> {
                final String vertexLabel = vertex.getLabel();
                final String edgeSymbol = "----";
                final Map<String, Edge> edges = vertex.getEdges();
                edges.forEach((key, value) -> {
                    stringBuilder
                            .append(vertexLabel)
                            .append(" ")
                            .append(edgeSymbol)
                            .append(" ")
                            .append(value.getWeight())
                            .append(" ")
                            .append(edgeSymbol)
                            .append(" ")
                            .append(key)
                            .append("\n\n");
                });
            });
        }
        return stringBuilder.toString();
    }


    public List<Vertex> formTree(final List<Vertex> graph) {

        LOGGER.info("Received Graph: " + graph);
        if (graph == null || graph.isEmpty() || graph.size() <= 1) {
            return graph;
        }
        final Map<String, Vertex> vertexLookUp = new HashMap<>();
        graph.forEach((vertex -> {
            vertexLookUp.put(vertex.getLabel(), vertex);
        }));
        LOGGER.info("Vertex Lookup: " + vertexLookUp);
        final Map<String, Vertex> result = new HashMap<>();
        final Set<String> visitedVertices = new LinkedHashSet<>();
        final Map<String, Edge> visitedEdges = initVisitedEdges(graph);
        final AtomicReference<Vertex> source = new AtomicReference<>(graph.get(0));
        visitedEdges.put(source.get().getLabel(), new Edge(0L));
        while (visitedVertices.size() <= graph.size()) {
            visitedVertices.add(source.get().getLabel());
            final Map<String, Edge> edges = source.get().getEdges();
            edges.entrySet().forEach((stringEdgeEntry -> {
                final String vertexName = stringEdgeEntry.getKey();
                final Edge vertexEdge = stringEdgeEntry.getValue();
                if (!visitedVertices.contains(vertexName) &&
                        vertexEdge.compareTo(visitedEdges.get(vertexName)) < 0) {
                    visitedEdges.replace(vertexName, vertexEdge);
                }
            }));
            final Pair<String, Edge> pair = getVertexLabelWithMinEdge(visitedEdges, visitedVertices);
            if (!pair.isEmpty()) {

                Vertex v1;
                Vertex v2;
                if (result.containsKey(source.get().getLabel())) {
                    v1 = result.get(source.get().getLabel());
                } else {
                    v1 = new Vertex(source.get().getLabel());
                }
                if (result.containsKey(pair.getKey())) {
                    v2 = result.get(pair.getKey());
                } else {
                    v2 = new Vertex(pair.getKey());
                }
                final Edge edge = new Edge(pair.getValue().getWeight());
                LOGGER.info("V1: " + v1);
                LOGGER.info("V2: " + v2);
                v1.addEdge(v2.getLabel(), edge);
                v2.addEdge(v1.getLabel(), edge);
                result.put(v1.getLabel(), v1);
                result.put(v2.getLabel(), v2);
                LOGGER.info("Result:\n" + result);
                source.set(vertexLookUp.get(pair.getKey()));
            }
            LOGGER.info("Visited Vertices: " + visitedVertices);
            LOGGER.info("Visited Edges: " + visitedEdges);
            if (visitedVertices.size() == graph.size()) {
                break;
            }
        }
        return new ArrayList<>(result.values());
    }

    private Map<String, Edge> initVisitedEdges(final List<Vertex> graph) {
        final Map<String, Edge> edges = new HashMap<>();
        graph.forEach((vertex) -> {
            edges.put(vertex.getLabel(), new Edge(Long.MAX_VALUE));
        });
        return edges;
    }

    private Pair<String, Edge> getVertexLabelWithMinEdge(final Map<String, Edge> visitedEdges, final Set<String> visitedVertices) {
        final AtomicReference<String> minVertexLabel = new AtomicReference<>();
        final AtomicReference<Edge> minVertexEdge = new AtomicReference<>();

        visitedEdges.forEach((key, value) -> {
            if (!visitedVertices.contains(key)) {
                if (minVertexLabel.get() == null && minVertexEdge.get() == null) {
                    minVertexLabel.set(key);
                    minVertexEdge.set(value);
                } else if (value.compareTo(minVertexEdge.get()) < 0) {
                    minVertexEdge.set(value);
                    minVertexLabel.set(key);
                }
            }
        });
        return new Pair<>(minVertexLabel.get(), minVertexEdge.get());
    }

    public static void main(String[] args) {
        final Vertex a = new Vertex("A");
        final Vertex b = new Vertex("B");
        final Vertex c = new Vertex("C");
        final Vertex d = new Vertex("D");
        final Vertex e = new Vertex("E");
        final Vertex f = new Vertex("F");
        final Vertex g = new Vertex("G");

        final Edge edgeAB = new Edge(3L);
        final Edge edgeAC = new Edge(5L);
        final Edge edgeAE = new Edge(2L);

        final Edge edgeBD = new Edge(6L);

        final Edge edgeCD = new Edge(8L);
        final Edge edgeCG = new Edge(9L);

        final Edge edgeEG = new Edge(5L);
        final Edge edgeEF = new Edge(11L);

        //Edge between A and B
        a.addEdge(b.getLabel(), edgeAB);
        b.addEdge(a.getLabel(), edgeAB);

        //Edge between A and C
        a.addEdge(c.getLabel(), edgeAC);
        c.addEdge(a.getLabel(), edgeAC);

        //Edge between A and E
        a.addEdge(e.getLabel(), edgeAE);
        e.addEdge(a.getLabel(), edgeAE);

        //Edge between B and D
        b.addEdge(d.getLabel(), edgeBD);
        d.addEdge(b.getLabel(), edgeBD);

        //Edge between C and D
        c.addEdge(d.getLabel(), edgeCD);
        d.addEdge(c.getLabel(), edgeCD);

        //Edge between C and G
        c.addEdge(g.getLabel(), edgeCG);
        g.addEdge(c.getLabel(), edgeCG);

        //Edge between E and F
        e.addEdge(f.getLabel(), edgeEF);
        f.addEdge(e.getLabel(), edgeEF);

        //Edge between E and G
        e.addEdge(g.getLabel(), edgeEG);
        g.addEdge(e.getLabel(), edgeEG);

        final List<Vertex> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);

        final PrimsMST primsMST = new PrimsMST();
        final List<Vertex> mst = primsMST.formTree(vertices);
        LOGGER.info("Min Sp Tree:\n" + mst);
        LOGGER.info("\n\n" + PrimsMST.convertToString(mst));
    }
}
