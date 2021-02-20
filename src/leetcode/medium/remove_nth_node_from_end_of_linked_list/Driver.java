package leetcode.medium.remove_nth_node_from_end_of_linked_list;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);

        Node<Integer> head = constructList(list);
//        System.out.println(getAsString(head));
        head = remove(head, 1);
        System.out.println(getAsString(head));
    }


    private static <E> Node<E> remove(final Node<E> head, final int n) {
        if (head == null) {
            return null;
        }

        Node<E> temp = head;
        final List<Node<E>> nodeList = new ArrayList<>();

        while (temp != null) {
            nodeList.add(temp);
            temp = temp.getNext();
        }

        if (n > nodeList.size()) {
            return null;
        }
        final int index = nodeList.size() - n;
        final Node<E> nodeToBeRemoved = nodeList.get(index);
        if (nodeToBeRemoved == head) {
            if (index + 1 < nodeList.size()) {
                final Node<E> headNext = head.getNext();
                head.setNext(null);
                return headNext;
            }
            return null;
        }

        final Node<E> nodePrev = nodeList.get(index - 1);
        final Node<E> nodeNext = (index + 1) < nodeList.size() ? nodeList.get(index + 1) : null;

        nodeToBeRemoved.setNext(null);
        nodePrev.setNext(nodeNext);
        return head;
    }

    private static <E> String getAsString(final Node<E> head) {
        final StringBuilder stringBuilder = new StringBuilder();
        Node<E> temp = head;
        while (temp != null) {
            stringBuilder.append(temp.getData());
            if (temp.hasNext()) {
                stringBuilder.append(" --> ");
            }
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }

    private static <E> Node<E> constructList(final List<E> list) {
        Node<E> head = null;
        Node<E> temp = null;
        if (list != null && list.size() > 0) {
            for (E item : list) {
                final Node<E> node = new Node<>(item);
                if (head == null) {
                    head = temp = node;
                } else {
                    temp.setNext(node);
                    temp = temp.getNext();
                }
            }
        }
        return head;
    }
}
