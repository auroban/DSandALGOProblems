package dsandalgos.linkedlists.find_last_2_survivors_in_N_persons;

import lombok.Data;

import java.util.List;

/**
 *
 * URL: https://www.geeksforgeeks.org/find-last-2-survivors-in-n-persons-standing-in-a-circle-after-killing-next-to-immediate-neighbour/
 *
 */

@Data
class Node<T> {
    private T data;
    private Node<T> next;

    Node(final T data) {
        this.data = data;
        this.next = null;
    }

    boolean hasNext() {
        return next != null;
    }
    static <T> Node<T> constructList(final List<T> items) {
        Node<T> head = null;
        Node<T> tail = null;
        for (int i = 0; i < items.size(); i++) {
            if (head == null) {
                head = new Node<>(items.get(i));
                tail = head;
            } else if (i == (items.size() - 1)) {
                final var n = new Node<>(items.get(i));
                n.setNext(head);
                tail.setNext(n);
                tail = tail.getNext();
            } else {
                final var n = new Node<>(items.get(i));
                tail.setNext(n);
                tail = tail.getNext();
            }
        }
        return head;
    }

    static <T> String asString(final Node<T> head) {
        final var stringBuilder = new StringBuilder();
        if (head != null) {
            stringBuilder.append(head.getData());
            var temp = head.getNext();
            while(temp != null && temp != head) {
                stringBuilder.append(" --> ").append(temp.getData());
                temp = temp.getNext();
            }
        }
        return stringBuilder.toString();
    }
}
