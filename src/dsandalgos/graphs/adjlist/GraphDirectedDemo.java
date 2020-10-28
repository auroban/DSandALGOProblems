package dsandalgos.graphs.adjlist;

public class GraphDirectedDemo {

	public static void main(String[] args) {

		// System.out.println("Please enter the vertices of the graph");
		// Scanner scanner = new Scanner(System.in);
		// // int V = scanner.nextInt();
		// scanner.nextLine();
		// scanner.close();
		GraphDirected graph = new GraphDirected(7);
		graph.connectVertices(1, 2);
		graph.connectVertices(1, 4);
		graph.connectVertices(2, 4);
		graph.connectVertices(2, 5);
		graph.connectVertices(3, 1);
		graph.connectVertices(3, 2);
		graph.connectVertices(3, 5);
		graph.connectVertices(7, 6);
		graph.displayGraph();
		graph.traverseBFS(7);

	}

}
