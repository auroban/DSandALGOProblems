package dsandalgos.linkedlists.find_last_2_survivors_in_N_persons;

import java.util.ArrayList;
import java.util.List;

class Test {

    public static void main(String[] args) {
        final List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);

        final var node = Node.constructList(integerList);
        System.out.println(Node.asString(node));
        final var survivorNodes = findLast2Survivors(node);
        System.out.println(Node.asString(survivorNodes));
    }

    public static <T> Node<T> findLast2Survivors(final Node<T> head) {
        if (head == null || !head.hasNext() || !head.getNext().hasNext()) {
            return head;
        }
        var temp = head;
        while (temp.getNext().getNext() != temp) {
            final var n = temp.getNext().getNext();
            final var nNext = n.getNext();
            var neighbor = temp.getNext();
            neighbor.setNext(nNext);
            n.setNext(null);
            temp = temp.getNext();
        }
        return temp;
    }
}
