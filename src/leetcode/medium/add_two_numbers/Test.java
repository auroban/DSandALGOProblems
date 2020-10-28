package leetcode.medium.add_two_numbers;

class Test {

    public static void main(String[] args) {
        final Integer[] array1 = {2, 4, 3};
        final Integer[] array2 = {5, 6, 4, 9};
        final ListNode listNode1 = ListNode.build(array1);
        final ListNode listNode2 = ListNode.build(array2);

        System.out.println(ListNode.asString(listNode1));
        System.out.println(ListNode.asString(listNode2));

        final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        final ListNode resultNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        System.out.println(ListNode.asString(resultNode));
    }
}
