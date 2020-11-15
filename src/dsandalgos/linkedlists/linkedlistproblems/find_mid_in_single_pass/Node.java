package dsandalgos.linkedlists.linkedlistproblems.find_mid_in_single_pass;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Node<T> {
    private final T data;
    private Node<T> next;

    public boolean hasNext() {
        return next != null;
    }
}
