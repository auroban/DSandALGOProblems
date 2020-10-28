package dsandalgos.graphs.adjlist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class GraphUndirectedDemo {

	public static void main(String[] args) {

		System.out.println("Please enter the number of vertices");
		Scanner scanner = new Scanner(System.in);
		int numOfVertices = scanner.nextInt();
		GraphUndirected graph = new GraphUndirected(numOfVertices);
		System.out.println("Please name the vertices");
		HashMap<String, Integer> nameNumMap = new HashMap<String, Integer>();
		for (int i = 0; i < numOfVertices; i++) {
			nameNumMap.put(scanner.next(), i);
		}
		scanner.nextLine();
		Set<String> keySet = nameNumMap.keySet();
		String[] response = new String[numOfVertices];

		for (String key : keySet) {
			System.out.println("Please enter the vertices connected to " + key + " separated by ','");
			String input = scanner.nextLine().replaceAll(" ", "");
			String[] vertices = input.split(",");
			for (String vertex : vertices) {
				graph.addEdge(nameNumMap.get(key), nameNumMap.get(vertex));
			}
		}
		scanner.close();

		for (String res : response) {
			System.out.println(res);
		}

		LinkedList<Integer>[] graphArray = (LinkedList<Integer>[]) graph.getGraphAsList();

		System.out.println("The formed Graph is:");
		Set<Entry<String, Integer>> entrySet = nameNumMap.entrySet();

		for (String key : keySet) {
			String res = "" + key + ":: ";
			LinkedList<Integer> linkedList = graphArray[nameNumMap.get(key)];
			Iterator<Integer> iterator = linkedList.iterator();
			while (iterator.hasNext()) {
				res = res + iterator.next();
				if (iterator.hasNext()) {
					res = res + " --> ";
				}
			}

			System.out.println(res);
		}

	}

}
