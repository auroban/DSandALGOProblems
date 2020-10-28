package dsandalgos.greedyalgos.primsminspanningtree;


public class Edge implements Comparable<Edge>{

    private Long weight;

    public Edge(final Long weight) {
        this.weight = weight;
    }

    public Long getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight.compareTo(o.getWeight());
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                '}';
    }
}
