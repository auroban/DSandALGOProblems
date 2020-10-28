package dsandalgos.sorting.topologicalsorting;

import java.util.List;

class Graph<E> {

	private List<Node<E>> vertices;
	
	public Graph(final List<Node<E>> vertices) {
		this.vertices = vertices;
	}
	
	public List<Node<E>> getVertices() {
		return vertices;
	}
	
	public int size() {
		return vertices.size();
	}
}
