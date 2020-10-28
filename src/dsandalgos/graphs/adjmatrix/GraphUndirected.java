package dsandalgos.graphs.adjmatrix;

import java.util.ArrayList;

public class GraphUndirected {

	private int[][] graph;
	private int size;

	public GraphUndirected(int size) {
		this.size = size;
		graph = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				graph[i][j] = 0;
			}
		}
	}

	public void addEdge(int vertex1, int vertex2) {
		if (vertex1 < size && vertex2 < size) {
			graph[vertex1][vertex2] = 1;
			graph[vertex2][vertex1] = 1;
		} else {
			System.err.println(
					"Error in adding edge " + vertex1 + " and " + vertex2 + "!!\nReason: Vertex should be within size");
		}
	}

	public boolean connected(int vertex1, int vertex2) {
		return (graph[vertex1][vertex2] == 1) && (graph[vertex2][vertex1] == 1);
	}

	public ArrayList<Integer> getAdjacentVetices(int vertex) {

		ArrayList<Integer> adjVerticesList = new ArrayList<Integer>();
		if (vertex < size) {
			for (int j = 0; j < size; j++) {
				if (graph[vertex][j] == 1 && graph[j][vertex] == 1) {
					adjVerticesList.add(j);
				}
			}
		} else {
			System.err.println("Error in getting adjacent vertices of vertex " + vertex
					+ "\nReason: Vertex should be within size");
		}
		return adjVerticesList;
	}

	public void displayGraph() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

}
