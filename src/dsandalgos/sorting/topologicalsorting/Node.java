package dsandalgos.sorting.topologicalsorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Node<E> {
	
	private static final Random RANDOM = new Random();
	
	private Long id;
	private E data;
	private List<Node<E>> neighbors;
	
	public Node(final E data) {
		id = RANDOM.nextLong();
		this.data = data;
		neighbors = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	
	public E getData() {
		return data;
	}
	
	public Node<E> addNeighbor(final Node<E> neighborNode) {
		neighbors.add(neighborNode);
		return this;
	}
	
	public List<Node<E>> getNeighbors() {
		return neighbors;
	}
	

}
