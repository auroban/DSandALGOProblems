package linkedlistproblems.examples.addTwoNums;

/**
 * 
 * @author auro
 * 
 *         You are given two non-empty linked lists representing two
 *         non-negative integers. The digits are stored in reverse order and
 *         each of their nodes contain a single digit. Add the two numbers and
 *         return it as a linked list.
 * 
 *         You may assume the two numbers do not contain any leading zero,
 *         except the number 0 itself.
 * 
 *         Example:
 *         
 *         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 *         Output: 7 -> 0 -> 8 
 *         Explanation: 342 + 465 = 807.
 *
 * 		   URL: https://leetcode.com/problems/add-two-numbers/
 */

class AddTwoNumsInRevLinkedList {

	/**
	 * 
	 * @param args
	 * 
	 * The idea here to initialize the LinkedLists is slightly tricky
	 * You have to maintain 3 pointers to the same node at all time.
	 * One pointing to its head so you can have the starting point of the LinkedList (headToL1)
	 * One pointing to the current node (l1) to move through the LinkedList
	 * One point to the node previous to the current node (l1Prev)
	 * 
	 * Pointer to previous node is required because when all the items are entered into the 
	 * LinkedList, the last node (pointed by the current one) always gets initialized with a default node
	 * Prev node pointer can set its next to null to ensure the last default node it cut-off from the chain
	 * 
	 * Initially the prevNode pointer and the currentNode pointer point to the same node. 
	 * As the current node moves to the next node, the pointer to prevNode points to the node before the
	 * current node
	 */
	public static void main(String[] args) {

		int[] arr1 = { 5 };
		int[] arr2 = { 5 };
		
		ListNode l1, l1Prev, headToL1;
		ListNode l2, l2Prev, headToL2;
		
		l1 = l1Prev = headToL1 = new ListNode(0);
		l2 = l2Prev = headToL2 = new ListNode(0);
		
		for (int item : arr1) {
			l1.val = item;
			l1.next = new ListNode(0);
			if (l1 != l1Prev) {
				l1Prev = l1;
			}
			l1 = l1.next;
		}
		l1Prev.next = null;
		
		for (int item : arr2) {
			l2.val = item;
			l2.next = new ListNode(0);
			if (l2 != l2Prev) {
				l2Prev = l2;
			}
			l2 = l2.next;
		}
		l2Prev.next = null;
		
		System.out.println("First LinkedList:\n");
		l1 = headToL1;
		while (l1 != null) {
			System.out.print(l1.val);
			if (l1.next != null) {
				System.out.print(" --> ");
			}
			l1 = l1.next;
		}
		
		System.out.println("\n\n");
		System.out.println("Second LinkedList:\n");
		l2 = headToL2;
		while (l2 != null) {
			System.out.print(l2.val);
			if (l2.next != null) {
				System.out.print(" --> ");
			}
			l2 = l2.next;
		}
		
		AddTwoNumsInRevLinkedList a = new AddTwoNumsInRevLinkedList();
		ListNode resultantListNode = a.addTwoNumbers(headToL1, headToL2);
		System.out.println("\n\n");
		System.out.println("Resultant LinkedList:\n");
		while (resultantListNode != null) {
			System.out.print(resultantListNode.val);
			if (resultantListNode.next != null) {
				System.out.print(" --> ");
			}
			resultantListNode = resultantListNode.next;
		}
	}
	
	/**
	 * SOLUTION ==>
	 * 
	 * @param l1
	 * @param l2
	 * @return Resultant ListNode
	 * 
	 * The idea is to run a while loop as long as both of the nodes are not null
	 * Add values from both the nodes. In case of carry, carry it forward to the 
	 * next iteration.
	 * Once either of the LinkedList terminates, the while loop also terminates
	 * After that, check for the remaining LinkedList and run a loop over it to 
	 * add the additional digits 
	 * 
	 * All the additions are stored in a resultant array.
	 * 
	 * Always maintain two pointers to the same node, one to stay at its head
	 * and the other to move through the LinkedList 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null && l2 != null) {
			return l2;
		}

		if (l2 == null && l1 != null) {
			return l1;
		}

		ListNode resultNode = new ListNode(0);
		ListNode headToResultNode = resultNode;
		ListNode resultNodePrev = resultNode;
		int carry = 0;

		while (l1 != null && l2 != null) {
			int valA = l1.val;
			int valB = l2.val;

			int valC = (valA + valB + carry) % 10;
			carry = (valA + valB + carry) / 10;
			resultNode.val = valC;
			resultNode.next = new ListNode(0);
			if (resultNodePrev != resultNode) {
				resultNodePrev = resultNode;
			}
			resultNode = resultNode.next;

			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int val = (l1.val + carry) % 10;
			resultNode.val = val;
			resultNode.next = new ListNode(0);
			if (resultNodePrev != resultNode) {
				resultNodePrev = resultNode;
			}
			resultNode = resultNode.next;
			carry = (l1.val + carry) / 10;
			l1 = l1.next;
		}

		while (l2 != null) {
			int val = (l2.val + carry) % 10;
			resultNode.val = val;
			resultNode.next = new ListNode(0);
			if (resultNodePrev != resultNode) {
				resultNodePrev = resultNode;
			}
			resultNode = resultNode.next;
			carry = (l2.val + carry) / 10;
			l2 = l2.next;
		}
		
		if (carry > 0) {
			resultNode.val = carry;
			resultNode.next = new ListNode(0);
			if (resultNodePrev != resultNode) {
				resultNodePrev = resultNode;
			}
			resultNode = resultNode.next;
		}

		resultNodePrev.next = null;
		return headToResultNode;

	}

}
