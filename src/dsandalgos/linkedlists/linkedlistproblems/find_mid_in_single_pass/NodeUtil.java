package dsandalgos.linkedlists.linkedlistproblems.find_mid_in_single_pass;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

class NodeUtil<T> {

    private Node<T> mid;
    private int length = 0;

    public Node<T> findMid(final Node<T> head) {
        if (head != null) {
            traverse(head, 0);
        }
        return mid;
    }

    private void traverse(final Node<T> node, int count) {
        length++;
        count++;
        System.out.println("Length at beginning: " + length);
        System.out.println("Count at beginning: " + count);

        if (node.hasNext()) {
            traverse(node.getNext(), count);
        }

        System.out.println("Length now: " + length);
        System.out.println("Count now: " + count);

        final var midPoint = BigDecimal.valueOf(length).divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP).intValue();
        System.out.println("Mid Point: " + midPoint);
        if (midPoint == count) {
            System.out.println("Bingo!!! Found it: " + node);
            mid = node;
        }
    }

    public static <T> String getAsString(final Node<T> head) {
        final StringBuilder stringBuilder = new StringBuilder();
        var temp = head;
        while (temp != null) {
            stringBuilder.append(temp.getData());
            if (temp.hasNext()) {
                stringBuilder.append(" --> ");
            }
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }

    public static <T> Node<T> constructList(final ArrayList<T> arrayList) {
        Node<T> head = null, temp = null;
        for (T t : arrayList) {
            var node = new Node<>(t);
            if (head == null) {
                head = temp = node;
            } else {
                temp.setNext(node);
                temp = temp.getNext();
            }
        }
        return head;
    }
}
