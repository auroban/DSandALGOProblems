package dsandalgos.linkedlists.flatten_linked_list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Driver {

    public static void main(String[] args) {

        var linkedListFlattener = new LinkedListFlattener();
        final Integer[] firstDownArray = { 5, 7, 8, 30 };
        final Integer[] secondDownArray = { 10, 20 };
        final Integer[] thirdDownArray = { 19, 22, 50 };
        final Integer[] fourthDownArray = { 28, 35, 40, 45 };
        final var firstDownList = linkedListFlattener.constructDownList(new ArrayList<>(Arrays.asList(firstDownArray)));
        final var secondDownList = linkedListFlattener.constructDownList(new ArrayList<>(Arrays.asList(secondDownArray)));
        final var thirdDownList = linkedListFlattener.constructDownList(new ArrayList<>(Arrays.asList(thirdDownArray)));
        final var fourthDownList = linkedListFlattener.constructDownList(new ArrayList<>(Arrays.asList(fourthDownArray)));

        final var arrayList = new ArrayList<Node<Integer>>();
        arrayList.add(firstDownList);
        arrayList.add(secondDownList);
        arrayList.add(thirdDownList);
        arrayList.add(fourthDownList);

        final var head = linkedListFlattener.constructRightList(arrayList);
        System.out.println(linkedListFlattener.getAsString(head));
        final var flattenedHead = linkedListFlattener.flatten(head);
        System.out.println(linkedListFlattener.getAsString(flattenedHead));
    }
}
