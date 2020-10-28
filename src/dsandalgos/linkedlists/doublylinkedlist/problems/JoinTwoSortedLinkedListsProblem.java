package dsandalgos.linkedlists.doublylinkedlist.problems;

import java.util.ArrayList;

import dsandalgos.linkedlists.doublylinkedlist.DoublyLinkedList;
import dsandalgos.linkedlists.doublylinkedlist.Node;
/*
 * Given two sorted Doubly LinkedLists, merge them such that the resultant LinkedList is also sorted
 */
public class JoinTwoSortedLinkedListsProblem {

	public static void main(String[] args) {
		
		ArrayList<Integer> itemListA = new ArrayList<Integer>();
		ArrayList<Integer> itemListB = new ArrayList<Integer>();
		itemListA.add(12);
		itemListA.add(22);
		itemListA.add(50);
		itemListB.add(2);
		itemListB.add(20);
		itemListB.add(100);
		DoublyLinkedList<Integer> linkedListA = new DoublyLinkedList<>(itemListA);
		DoublyLinkedList<Integer> linkedListB = new DoublyLinkedList<>(itemListB);
		linkedListA.displayItems();
		linkedListB.displayItems();
		
		/*
		 * The idea here is to create an empty node, iterate over both the LinkedLists, compare the values of the current nodes of both the LinkedLists
		 * and add the suitable one to the end of the empty list. Thus the resultant LinkedList will be a list beginning with an empty node. 
		 */
		Node<Integer> resultantNode = new Node<Integer>(null, null, null);
		Node<Integer> headNode = resultantNode;
		joinTwoLinkedLists(linkedListA.getHead(), linkedListB.getHead(), resultantNode);
		displayLinkedList(headNode.getNext());
	}
	
	private static void joinTwoLinkedLists(Node<Integer> nodeA, Node<Integer> nodeB, Node<Integer> resultantNode) {
		if (nodeA != null && nodeB == null) {
			resultantNode.setNext(nodeA);
			nodeA.setPrevious(resultantNode);
		}
		else if (nodeA == null && nodeB != null) {
			resultantNode.setNext(nodeB);
			nodeB.setPrevious(resultantNode);
		}
		else if (nodeA != null && nodeB != null) {
			int itemNodeA = nodeA.getItem();
			int itemNodeB = nodeB.getItem();
			if (itemNodeA < itemNodeB) {
				resultantNode.setNext(new Node<Integer>(resultantNode, null, itemNodeA));
				resultantNode = resultantNode.getNext();
				joinTwoLinkedLists(nodeA.getNext(), nodeB, resultantNode);
			}
			else if (itemNodeA > itemNodeB) {
				resultantNode.setNext(new Node<Integer>(resultantNode, null, itemNodeB));
				resultantNode = resultantNode.getNext();
				joinTwoLinkedLists(nodeA, nodeB.getNext(), resultantNode);
			}
			else {
				resultantNode.setNext(new Node<Integer>(resultantNode, null, itemNodeA));
				resultantNode = resultantNode.getNext();
				joinTwoLinkedLists(nodeA.getNext(), nodeB.getNext(), resultantNode);
			}
		}
	}
	
	private static void displayLinkedList(Node<Integer> node) {
		StringBuilder reStringBuilder = new StringBuilder();
		
		while (node != null) {
			if (node.getPrevious() != null && node.getPrevious().getItem() != null) {
				reStringBuilder.append(" <--> ");
			}
			reStringBuilder.append(node.getItem());	
			node = node.getNext();
		}
		System.out.println(reStringBuilder.toString());
	}

}
