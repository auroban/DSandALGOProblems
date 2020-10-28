package leetcode.medium.add_two_numbers;

/**
 * Problem: https://leetcode.com/problems/add-two-numbers/
 */

class AddTwoNumbers {

    public ListNode addTwoNumbers(final ListNode listNode1, final ListNode listNode2) {

        if (listNode1 == null || listNode2 == null) {
            return null;
        }

        int carry = 0;
        ListNode resultNode = null;
        ListNode headResult = null;
        ListNode temp1 = listNode1;
        ListNode temp2 = listNode2;

        while (temp1 != null && temp2 != null) {
            System.out.println("Adding: " + temp1.getData() + " with " + temp2.getData());
            final int sum = temp1.getData() + temp2.getData() + carry;
            System.out.println("Sum: " + sum);
            final int result = sum % 10;
            carry = sum / 10;
            System.out.println("Result: " + result);
            System.out.println("Carry: " + carry);

            final ListNode newNode = new ListNode(result, null);
            if (resultNode == null) {
                resultNode = newNode;
                headResult = resultNode;
            } else {
                resultNode.setNext(newNode);
                resultNode = resultNode.getNext();
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }

        while (temp1 != null) {
            System.out.println("Temp1: " + temp1);
            int sum = temp1.getData() + carry;
            int result = sum % 10;
            carry = sum / 10;
            final ListNode newNode = new ListNode(result, null);
            if (resultNode == null) {
                resultNode = newNode;
            } else {
                resultNode.setNext(newNode);
                resultNode = resultNode.getNext();
            }
            temp1 = temp1.getNext();
        }

        while (temp2 != null) {
            System.out.println("Temp2: " + temp2);
            int sum = temp2.getData() + carry;
            int result = sum % 10;
            carry = sum / 10;
            final ListNode newNode = new ListNode(result, null);
            if (resultNode == null) {
                resultNode = newNode;
                headResult = resultNode;
            } else {
                resultNode.setNext(newNode);
                resultNode = resultNode.getNext();
            }
            temp2 = temp2.getNext();
        }

        if (carry > 0) {
            final ListNode newNode = new ListNode(carry, null);
            if (resultNode == null) {
                resultNode = newNode;
                headResult = resultNode;
            } else {
                resultNode.setNext(newNode);
                resultNode = resultNode.getNext();
            }
        }
        return headResult;
    }
}
