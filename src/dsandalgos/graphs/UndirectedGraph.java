package dsandalgos.graphs;

import java.util.*;

public class UndirectedGraph<T extends Comparable<T>> extends Graph<T> {

    private final Map<String, List<Vertex<T>>> map;
    private final Map<String, Vertex<T>> vertices;

    public UndirectedGraph() {
        map = new HashMap<>();
        vertices = new HashMap<>();
    }

    @Override
    public void addVertex(final Vertex<T> vertex) {
        if (!vertices.containsKey(vertex.getName())) {
            vertices.put(vertex.getName(), vertex);
            map.put(vertex.getName(), new ArrayList<>());
        }
    }

    @Override
    public void addEdge(final String source, final String destination) {
        if (!vertices.containsKey(source)) {
            throw new RuntimeException("No Such Vertex found by Name: " + source);
        }

        if (!vertices.containsKey(destination)) {
            throw new RuntimeException("No Such Vertex found by Name: " + destination);
        }

        final var sourceList = map.get(source);
        final var destinationList = map.get(destination);

        final var sourceVertex = vertices.get(source);
        final var destinationVertex = vertices.get(destination);

        sourceList.add(destinationVertex);
        destinationList.add(sourceVertex);
    }

    @Override
    public List<Vertex<T>> getAllVertices() {
        return new ArrayList<>(vertices.values());
    }

    @Override
    public Optional<Vertex<T>> getVertex(final String vertexName) {
        final var vertex = vertices.getOrDefault(vertexName, null);
        return Optional.ofNullable(vertex);
    }

    @Override
    public List<Vertex<T>> getAllNeighbors(final String vertexName) {
        return map.getOrDefault(vertexName, new ArrayList<>(0));
    }
}
