package dsandalgos.graphs.adjmatrix;

import java.util.ArrayList;

public class GraphDemo {

	public static void main(String[] args) {

		GraphUndirected graph = new GraphUndirected(8);
		graph.addEdge(0, 7);
		graph.addEdge(1, 5);
		graph.addEdge(7, 2);
		graph.displayGraph();
		System.out.println(graph.connected(7, 7));
		ArrayList<Integer> adjList = graph.getAdjacentVetices(7);
		for (int i : adjList) {
			System.out.print(i + " - ");
		}

	}

}
