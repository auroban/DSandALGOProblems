package leetcode.medium.remove_nth_node_from_end_of_linked_list;

import lombok.Getter;
import lombok.Setter;

class Node<E> {

    @Getter
    private final E data;

    @Getter
    @Setter
    private Node<E> next;

    public Node(final E data) {
        this.data = data;
        next = null;
    }

    public boolean hasNext() {
        return next != null;
    }

}
