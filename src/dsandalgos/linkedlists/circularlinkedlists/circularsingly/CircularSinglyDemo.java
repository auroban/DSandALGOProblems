package dsandalgos.linkedlists.circularlinkedlists.circularsingly;

import java.util.ArrayList;
import java.util.Scanner;

public class CircularSinglyDemo {

	public static void main(String[] args) {
		
		System.out.println("Please enter the nodes of the LinkedList");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			itemList.add(scanner.nextInt());
		}
		scanner.close();
		CircularSinglyLinkedList<Integer> csll = new CircularSinglyLinkedList<>(itemList);
		csll.displayItems();
	}

}
