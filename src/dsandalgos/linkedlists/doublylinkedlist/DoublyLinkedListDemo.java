package dsandalgos.linkedlists.doublylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		System.out.println("Please enter the items of the Doubly LinkedList");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			itemList.add(scanner.nextInt());
		}
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>(itemList);
		doublyLinkedList.displayItems();
		System.out.println("After deletion at Front");
		doublyLinkedList.displayItemsFromLinkedList(doublyLinkedList.deleteAtFront());
		System.out.println("After deletion at End");
		doublyLinkedList.displayItemsFromLinkedList(doublyLinkedList.deleteAtEnd());
		System.out.println("Please enter a point of deletion");
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		int pointOfDeletion = scanner.nextInt();
		scanner.close();
		doublyLinkedList.displayItemsFromLinkedList(doublyLinkedList.deleteAtAGivenPoint(pointOfDeletion));
	}

}
