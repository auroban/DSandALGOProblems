package dsandalgos.linkedlists.singlylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

public class SinglyLinkedListDemo {

	public static void main(String[] args) {

		System.out.println("Please enter the elements to be inserted into the array::::\n\nPress any character to exit");;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			itemList.add(scanner.nextInt());
		}
		System.out.println("The LinkedList comprises of the following elements:");
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>(itemList);
		singlyLinkedList.displayItems();
		System.out.println("After deletion at Front"); 
		singlyLinkedList.displayItemsFromALinkedList(singlyLinkedList.deleteAtFront());
		System.out.println("After deletion at End");
		singlyLinkedList.displayItemsFromALinkedList(singlyLinkedList.deleteAtEnd());
		System.out.println("Please enter the point of deletion");
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		int pointOfDeletion = scanner.nextInt();
		scanner.close();
		singlyLinkedList.displayItemsFromALinkedList(singlyLinkedList.deleteAtAGivenPoint(pointOfDeletion));

	}

}
