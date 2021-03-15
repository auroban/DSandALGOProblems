package dsandalgos.graphs;

public class Vertex<T extends Comparable<T>> {

    private final String name;
    private Boolean visited;
    private T data;

    public Vertex(final String name) {
        this(name, null);
    }

    public Vertex(final String name, final T data) {
        this.name = name;
        this.data = data;
        visited = Boolean.FALSE;
    }

    public String getName() {
        return name;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public Boolean isVisited() {
        return visited;
    }

    public void setVisited(final Boolean visited) {
        this.visited = visited;
    }
}
