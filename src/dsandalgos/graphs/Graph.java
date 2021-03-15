package dsandalgos.graphs;

import java.util.List;
import java.util.Optional;

public abstract class Graph<T extends Comparable<T>> {

    public abstract void addVertex(final Vertex<T> vertex);

    public abstract void addEdge(final String source, final String destination);

    public abstract List<Vertex<T>> getAllVertices();

    public abstract Optional<Vertex<T>> getVertex(final String vertexName);

    public abstract List<Vertex<T>> getAllNeighbors(final String vertexName);
}
