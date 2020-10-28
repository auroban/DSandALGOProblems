package leetcode.medium.add_two_numbers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
class ListNode {
    private Integer data;
    private ListNode next;

    public static String asString(ListNode listNode) {
        final StringBuilder stringBuilder = new StringBuilder();
        while (listNode != null) {
            stringBuilder.append(listNode.getData());
            if (listNode.getNext() != null) {
                stringBuilder.append(" ==> ");
            }
            listNode = listNode.getNext();
        }
        return stringBuilder.toString();
    }

    public static ListNode build(final Integer[] integers) {
        ListNode listNode = null;
        ListNode head = null;
        if (integers != null) {
            for (Integer integer: integers) {
                final ListNode newNode = new ListNode(integer, null);
                if (listNode == null) {
                    listNode = newNode;
                    head = listNode;
                } else {
                    listNode.setNext(newNode);
                    listNode = listNode.getNext();
                }
            }
        }
        return head;
    }

}
