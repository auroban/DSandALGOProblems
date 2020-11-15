package dsandalgos.linkedlists.flatten_linked_list;

import java.util.ArrayList;

/**
 * Source: https://www.geeksforgeeks.org/flattening-a-linked-list/
 */

class LinkedListFlattener {

    <T extends Comparable<T>> Node<T> flatten(final Node<T> node) {
        if (node != null) {
            final var right = flatten(node.getRight());
            return sort(node, right);
        }
        return null;
    }

    private <T extends Comparable<T>> Node<T> sort(Node<T> node, Node<T> right) {

        Node<T> head = null;
        Node<T> list = null;

        System.out.println("Sorting Node: " + node);
        System.out.println("Sorting Right: " + right);

        while (node != null && right != null) {
            final T item1 = node.getData();
            final T item2 = right.getData();
            if (item1.compareTo(item2) < 0) {
                final var newNode = new Node<>(item1);
                if (head == null) {
                    head = list = newNode;
                } else {
                    list.setRight(newNode);
                    list = list.getRight();
                }
                node = node.getDown();
            } else if (item1.compareTo(item2) > 0) {
                final var newNode = new Node<>(item2);
                if (head == null) {
                    head = list = newNode;
                } else {
                    list.setRight(newNode);
                    list = list.getRight();
                }
                right = right.getRight();
            } else {
                final var newNode1 = new Node<>(item1);
                final var newNode2 = new Node<>(item2);
                if (head == null) {
                    head = list = newNode1;
                    list.setRight(newNode2);
                    list = list.getRight();
                } else {
                    list.setRight(newNode1);
                    list = list.getRight();
                    list.setRight(newNode2);
                    list = list.getRight();
                }
                node = node.getDown();
                right = right.getRight();
            }
        }

        while (node != null) {
            if (head == null) {
                head = list = new Node<>(node.getData());
            } else {
                list.setRight(new Node<>(node.getData()));
                list = list.getRight();
            }
            node = node.getDown();
        }

        while (right != null) {
            if (head == null) {
                head = list = new Node<>(right.getData());
            } else {
                list.setRight(new Node<>(right.getData()));
                list = list.getRight();
            }
            right = right.getRight();
        }

        return head;
    }

    public <T extends Comparable<T>> Node<T> constructDownList(final ArrayList<T> arrayList) {
        Node<T> head = null, list = null;
        for (T t : arrayList) {
            final var newNode = new Node<>(t);
            if (head == null) {
                head = list = newNode;
            } else {
                list.setDown(newNode);
                list = list.getDown();
            }
        }
        return head;
    }

    public <T extends Comparable<T>> Node<T> constructRightList(final ArrayList<Node<T>> arrayList) {
        Node<T> head = null, list = null;
        for (var node : arrayList) {
            if (head == null) {
                head = list = node;
            } else {
                list.setRight(node);
                list = list.getRight();
            }
        }
        return head;
    }

    public <T extends Comparable<T>> String getAsString(final Node<T> node) {
        final var stringBuilder = new StringBuilder();
        var temp = node;
        while (temp != null) {
            var down = temp;
            final var inner = new StringBuilder();
            while (down != null) {
                inner.append(down.getData());
                if (down.getDown() != null) {
                    inner
                            .append(System.lineSeparator())
                            .append("|")
                            .append(System.lineSeparator())
                            .append("|")
                            .append(System.lineSeparator())
                            .append("V")
                            .append(System.lineSeparator());
                }
                down = down.getDown();
            }
            stringBuilder.append(inner);
            if (temp.getRight() != null) {
                stringBuilder.append("  --->  ");
            }
            temp = temp.getRight();
        }
        return stringBuilder.toString();
    }
}
