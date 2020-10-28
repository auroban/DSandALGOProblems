package dsandalgos.linkedlists.singlylinkedlist.problems;

import java.util.ArrayList;

import dsandalgos.linkedlists.singlylinkedlist.Node;
import dsandalgos.linkedlists.singlylinkedlist.SinglyLinkedList;

/*
 * Given two sorted Singly LinkedLists, merge them in such a way that the resultant LinkedList is also sorted
 */

public class JoiningTwoSortedLinkedListsProblem {

	public static void main(String[] args) {

		ArrayList<Integer> itemListA = new ArrayList<Integer>();
		ArrayList<Integer> itemListB = new ArrayList<Integer>();
		itemListA.add(10);
		itemListA.add(23);
		itemListA.add(33);
		itemListB.add(5);
		itemListB.add(13);
		itemListB.add(50);
		itemListB.add(100);
		SinglyLinkedList<Integer> linkedListA = new SinglyLinkedList<>(itemListA);
		SinglyLinkedList<Integer> linkedListB = new SinglyLinkedList<>(itemListB);
		
		/*
		 * The idea here is to create an empty node, iterate over both the LinkedLists, compare the values of the current nodes of both the LinkedLists
		 * and add the suitable one to the end of the empty list. Thus the resultant LinkedList will be a list beginning with an empty node. 
		 */
		Node<Integer> tailresultantNode = new Node<Integer>(null, null);
		Node<Integer> headResultantNode = tailresultantNode;
		joinLinkedLists(linkedListA.getHead(), linkedListB.getHead(), tailresultantNode);
		StringBuilder result = new StringBuilder();
		Node<Integer> startNode = headResultantNode.getNext();
		while (startNode != null) {
			result.append(startNode.getItem());
			if (startNode.getNext() != null) {
				result.append(" --> ");
			}
			startNode = startNode.getNext();
		}
		System.out.println(result.toString());
	}
	
	private static void joinLinkedLists(Node<Integer> nodeA, Node<Integer> nodeB, Node<Integer> tailResultantNode) {
		
		if (nodeA == null && nodeB == null) {
		}
		else if (nodeA != null && nodeB == null) {
			tailResultantNode.setNext(nodeA);
		}
		else if (nodeA == null && nodeB != null) {
			tailResultantNode.setNext(nodeB);
		}
		else {
			int itemNodeA = nodeA.getItem().intValue();
			int itemNodeB = nodeB.getItem().intValue();
			
			if (itemNodeA < itemNodeB) {
				tailResultantNode.setNext(new Node<Integer>(null, itemNodeA));
				tailResultantNode = tailResultantNode.getNext();
				joinLinkedLists(nodeA.getNext(), nodeB, tailResultantNode);
			}
			else if (itemNodeA == itemNodeB) {
				tailResultantNode.setNext(new Node<Integer>(null, itemNodeA));
				tailResultantNode = tailResultantNode.getNext();
				joinLinkedLists(nodeA.getNext(), nodeB.getNext(), tailResultantNode);
			}
			else {
				tailResultantNode.setNext(new Node<Integer>(null, itemNodeB));
				tailResultantNode = tailResultantNode.getNext();
				joinLinkedLists(nodeA, nodeB.getNext(), tailResultantNode);
			}
		}
	}

}
