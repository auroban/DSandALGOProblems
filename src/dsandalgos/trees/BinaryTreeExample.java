package dsandalgos.trees;

import java.util.ArrayList;

import dsandalgos.linkedlists.doublylinkedlist.DoublyLinkedList;
import dsandalgos.linkedlists.singlylinkedlist.SinglyLinkedList;

public class BinaryTreeExample {

	public static void main(String[] args) {

		int[] intArr = { 20, 15, 25, 10, 16, 23, 26, 8, 14, 21, 24 };
		// System.out.println("Please enter the elements of the Binary Tree");
		// Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		for (int i : intArr) {
			itemList.add(i);
		}
		// while (scanner.hasNextInt()) {
		// itemList.add(scanner.nextInt());
		// }
		itemList.add(20);
		itemList.add(20);
		BinarySearchTreeUtils binarySearchTreeUtils = BinarySearchTreeUtils.getInstance();
		Node root = binarySearchTreeUtils.getBinarySearchTree(itemList);
		System.out.println("RootNode:\t" + root.getData());
		binarySearchTreeUtils.inOrder(root);
		dsandalgos.linkedlists.singlylinkedlist.Node<Integer> node = binarySearchTreeUtils.toSinglyLinkedList(root);
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(null);
		singlyLinkedList.displayItemsFromALinkedList(node);

		System.out.println("Doubly Linked List::::");
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>(null);
		doublyLinkedList.displayItemsFromLinkedList(binarySearchTreeUtils.toDoublyLinkedList(root));

		binarySearchTreeUtils.preOrder(root);
		binarySearchTreeUtils.postOrder(root);

	}

}
