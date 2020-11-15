package dsandalgos.linkedlists.flatten_linked_list;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Node<T extends Comparable<T>> {
    private final T data;
    private Node<T> down;
    private Node<T> right;
}
