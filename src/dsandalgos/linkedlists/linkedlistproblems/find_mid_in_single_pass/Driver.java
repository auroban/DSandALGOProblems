package dsandalgos.linkedlists.linkedlistproblems.find_mid_in_single_pass;

import java.util.ArrayList;
import java.util.Arrays;

class Driver {

    public static void main(String[] args) {
        final Integer[] intArray = {5, 7, 3, 2, 1, 9};
        final Node<Integer> head = NodeUtil.constructList(new ArrayList<>(Arrays.asList(intArray)));
        System.out.println(NodeUtil.getAsString(head));
        final var nodeUtil = new NodeUtil<Integer>();
        final var mid = nodeUtil.findMid(head);
        System.out.println("\n\n******************\n\n" + mid.getData() + "\n\n***********************\n\n");
    }
}
