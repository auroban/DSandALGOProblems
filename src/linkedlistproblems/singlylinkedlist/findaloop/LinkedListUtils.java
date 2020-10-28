package linkedlistproblems.singlylinkedlist.findaloop;

import java.util.HashSet;

class LinkedListUtils {

	static boolean hasALoop(final Node headNode) {

		if (headNode == null) {
			return false;
		}

		boolean loopFound = false;
		HashSet<Node> nodeSet = new HashSet<>();
		Node currentNode = headNode;

		while (currentNode != null) {
			nodeSet.add(currentNode);
			Node nextNode = currentNode.getNext();
			if (nextNode != null && nodeSet.contains(nextNode)) {
				loopFound = true;
				break;
			}
			currentNode = nextNode;
		}
		return loopFound;
	}

	static Node detectAndEliminateLoop(final Node headNode) {
		
		if (headNode == null) {
			return headNode;
		}

		HashSet<Node> nodeSet = new HashSet<>();
		Node nodePointingToLoop = null;
		Node currentNode = headNode;

		while (currentNode != null) {
			nodeSet.add(currentNode);
			Node next = currentNode.getNext();
			if (next != null && nodeSet.contains(next)) {
				nodePointingToLoop = currentNode;
				break;
			}
			currentNode = next;
		}

		if (nodePointingToLoop != null) {
			nodePointingToLoop.setNext(null);
		}

		return headNode;

	}

	static String getStringRepresentation(final Node headNode) {

		StringBuilder stringBuilder = new StringBuilder();

		if (headNode != null) {
			HashSet<Node> nodeSet = new HashSet<>();

			Node currentNode = headNode;
			while (currentNode != null) {
				nodeSet.add(currentNode);
				stringBuilder.append(currentNode.getValue());
				Node nextNode = currentNode.getNext();
				if (nextNode != null && nodeSet.contains(nextNode)) {
					stringBuilder.append("  ---->  ");
					stringBuilder.append(nextNode.getValue());
					break;
				}

				if (nextNode != null) {
					stringBuilder.append("  ---->  ");
				}
				currentNode = nextNode;
			}
		}
		return stringBuilder.toString();
	}

}
