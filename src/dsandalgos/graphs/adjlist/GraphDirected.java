package dsandalgos.graphs.adjlist;

import dsandalgos.linkedlists.singlylinkedlist.Node;
import dsandalgos.queues.Queue;
import dsandalgos.queues.QueueUnderflowException;

public class GraphDirected {

	private int V;
	private Node<Integer>[] adjListArray;
	private String traverseBFSResult = "";

	@SuppressWarnings("unchecked")
	public GraphDirected(int V) {
		this.V = V;
		adjListArray = (Node<Integer>[]) new Node[V];
		for (int i = 0; i < V; i++) {
			adjListArray[i] = null;
		}
	}

	public void connectVertices(int vertex1, int vertex2) {
		if ((--vertex1 < V) && (--vertex2 < V)) {
			if (!doesEdgeAlreadyExist(vertex1, vertex2)) {
				Node<Integer> adjList = adjListArray[vertex1];
				if (adjList == null) {
					adjList = new Node<Integer>(null, vertex2);
					adjListArray[vertex1] = adjList;
				} else {
					while (adjList.getNext() != null) {
						adjList = adjList.getNext();
					}
					adjList.setNext(new Node<Integer>(null, vertex2));
				}
			}
		}
	}

	public boolean isThereAnEdge(int from, int to) {

		if ((--from < V) && (--to < V)) {
			Node<Integer> node = adjListArray[from];
			while (node != null) {
				if (node.getItem().equals(to)) {
					return true;
				}
				node = node.getNext();
			}
		}
		return false;
	}

	public void displayGraph() {
		for (int i = 0; i < V; i++) {
			String res = (i + 1) + "::";
			Node<Integer> node = adjListArray[i];
			while (node != null) {
				res = res + (node.getItem() + 1);
				if (node.getNext() != null)
					res = res + " --> ";
				node = node.getNext();
			}
			System.out.println(res);
		}
	}

	public void traverseBFS(int rootVertex) {

		if (--rootVertex < V) {
			Queue<Integer> queue = new Queue<>();
			boolean[] visited = new boolean[V];
			for (int i = 0; i < V; i++) {
				visited[i] = false;
			}
			while (!allNodesVisited(visited)) {
				if (!visited[rootVertex]) {
					visited[rootVertex] = true;
					queue.enqueue(rootVertex);
					traverseBFS(queue, visited);
				} else {
					int index = getFirstUnvisitedIndex(visited);
					if (index > -1) {
						rootVertex = index;
					}
				}
			}
			System.out.println(traverseBFSResult);
		}
	}

	private void traverseBFS(Queue<Integer> queue, boolean[] visited) {
		try {
			if (!queue.isQueueEmpty()) {
				int item = queue.dequeue();
				traverseBFSResult = traverseBFSResult + (item + 1) + " ";
				Node<Integer> node = adjListArray[item];
				while (node != null) {
					if (!visited[node.getItem()]) {
						queue.enqueue(node.getItem());
						visited[node.getItem()] = true;
					}
					node = node.getNext();
				}
				traverseBFS(queue, visited);
			}

		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}

	}

	private void traverseDFS(int rootVertex) {
		if (--rootVertex < V) {
			boolean[] visited = new boolean[V];
			for (boolean bool : visited) {
				bool = false;
			}

			while (!allNodesVisited(visited)) {
				if (!visited[rootVertex]) {

				} else {
					int index = getFirstUnvisitedIndex(visited);

				}
			}

		}
	}

	private boolean allNodesVisited(boolean[] visited) {
		boolean visit = true;
		for (int i = 0; i < visited.length; i++) {
			visit = visit && visited[i];
		}
		return visit;
	}

	private boolean doesEdgeAlreadyExist(int vertex1, int vertex2) {
		Node<Integer> node = adjListArray[vertex1];
		while (node != null) {
			if (node.getItem().equals(vertex2)) {
				return true;
			}
			node = node.getNext();
		}
		return false;
	}

	private int getFirstUnvisitedIndex(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				System.out.println("Unvisited Node::" + (i + 1));
				return i;
			}
		}
		return -1;
	}

}
