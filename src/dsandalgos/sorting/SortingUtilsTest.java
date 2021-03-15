package dsandalgos.sorting;

public class SortingUtilsTest {

    public static void main(String[] args) {
        final Integer[] array = { 11, 9, 20, 0, 2, 5, -2 };
//        final Integer[] array = { 10, 9, 8, 7, 5, 2, 0 };
//        System.out.println(SortingUtils.getAsString(SortingUtils.bubbleSort(array)));
//        System.out.println(SortingUtils.getAsString(SortingUtils.insertionSort(array, SortingUtils.Order.DESC)));
        System.out.println(SortingUtils.getAsString(SortingUtils.quickSort(array)));
        System.out.println(SortingUtils.getAsString(SortingUtils.quickSort(array, SortingUtils.Order.DESC)));
    }
}
