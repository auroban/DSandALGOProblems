package dsandalgos.graphs.adjlist;

import java.util.LinkedList;

public class GraphUndirected {

	private LinkedList<Integer>[] linkedListArray;

	@SuppressWarnings("unchecked")
	public GraphUndirected(int noOfVertices) {
		linkedListArray = (LinkedList<Integer>[]) new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			linkedListArray[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int vertex1, int vertex2) {

		if (vertex1 < linkedListArray.length && vertex2 < linkedListArray.length) {
			linkedListArray[vertex1].add(vertex2);
			linkedListArray[vertex2].add(vertex1);
		}
	}

	public boolean areConnected(int vertex1, int vertex2) {

		return linkedListArray[vertex1].contains(vertex2) && linkedListArray[vertex2].contains(vertex1);
	}

	public LinkedList<Integer>[] getGraphAsList() {
		return linkedListArray;
	}

}
