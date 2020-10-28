package dsandalgos.sorting.topologicalsorting;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class GraphUtil {
	
	public static <E> boolean isCyclic(final Graph<E> graph) {
		final HashMap<Node<E>, Boolean> nodeVisitedMap = new HashMap<>();
		final Stack<Node<E>> orderStack = new Stack<>();
		if (graph == null || graph.size() == 0) {
			return false;
		}
		
		List<Node<E>> vertices = graph.getVertices();
		
		for (Node<E> vertex : vertices) {
			List<Node<E>> neighbors = vertex.getNeighbors();
			for (Node<E> neighbor : neighbors) {
				isCyclic(graph);
			}
		}
			
		return true;
	}
	
	public static <E> String topoSort(final Graph<E> graph) {
		
		return null;
	}
	
	
	private static <E> boolean isCyclic(
			final Node<E> node, 
			final Stack<Node<E>> orderStack, 
			final HashMap<Node<E>, Boolean> nodeVisitedMap) {
		
		List<Node<E>> neighbors = node.getNeighbors();
		for (Node<E> neighbor : neighbors) {
			if (!nodeVisitedMap.containsKey(neighbor)) {
				nodeVisitedMap.put(neighbor, true);
				orderStack.push(neighbor);
			} else {
				return false;
			}
		}
		
		return true;
	}

	
}
