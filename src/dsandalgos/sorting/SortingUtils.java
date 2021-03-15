package dsandalgos.sorting;

public class SortingUtils {

    public enum Order {
        ASC, DESC
    }

    public static String getAsString(final Integer[] array) {
        final StringBuilder stringBuilder = new StringBuilder();
        if (array != null && array.length > 0) {
            for (Integer integer : array) {
                stringBuilder.append(integer).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static Integer[] selectionSort(final Integer[] array) {
        return selectionSort(array, Order.ASC);
    }

    public static Integer[] selectionSort(final Integer[] array, final Order order) {

        if (Order.ASC.equals(order)) {
            return selectionSortAsc(array);
        } else {
            return selectionSortDesc(array);
        }
    }

    public static Integer[] bubbleSort(final Integer[] array) {
        return bubbleSort(array, Order.ASC);
    }

    public static Integer[] bubbleSort(final Integer[] array, final Order order) {
        if (Order.ASC.equals(order)) {
            return bubbleSortAsc(array);
        } else {
            return bubbleSortDesc(array);
        }
    }

    public static Integer[] insertionSort(final Integer[] array) {
        return insertionSort(array, Order.ASC);
    }

    public static Integer[] insertionSort(final Integer[] array, final Order order) {
        if (Order.ASC.equals(order)) {
            return insertionSortAsc(array);
        } else {
            return insertionSortDesc(array);
        }
    }

    public static Integer[] quickSort(final Integer[] array) {
        return quickSort(array, Order.ASC);
    }

    public static Integer[] quickSort(final Integer[] array, final Order order) {
        if (Order.DESC.equals(order)) {
            return quickSortDesc(array, 0, array.length - 1);
        } else {
            return quickSortAsc(array, 0, array.length - 1);
        }
    }

    private static Integer[] insertionSortAsc(final Integer[] array) {
        if (array != null && array.length > 1) {
            for (int i = 1; i < array.length; i++) {
                int key = array[i];
                for (int j = 0; j < i; j++) {
                    if (key < array[j]) {
                        array[i] = array[j];
                        array[j] = key;
                        key = array[i];
                    }
                }
            }
        }
        return array;
    }

    private static Integer[] insertionSortDesc(final Integer[] array) {
        if (array != null && array.length > 1) {
            for (int i = 1; i < array.length; i++) {
                int key = array[i];
                for (int j = 0; j < i; j++) {
                    if (key > array[j]) {
                        array[i] = array[j];
                        array[j] = key;
                        key = array[i];
                    }
                }
            }
        }
        return array;
    }


    private static Integer[] selectionSortAsc(final Integer[] array) {
        if (array != null && array.length > 1) {
            for (int i = 0; i < array.length - 1; i++) {
                int smallest = array[i];
                int smallestIndex = i;
                for (int j = i+1; j < array.length; j++) {
                    if (array[j] < smallest) {
                        smallest = array[j];
                        smallestIndex = j;
                    }
                }
                array[smallestIndex] = array[i];
                array[i] = smallest;
            }
        }
        return array;
    }

    private static Integer[] selectionSortDesc(final Integer[] array) {
        if (array != null && array.length > 1) {
            for (int i = 0; i < array.length - 1; i++) {
                int largest = array[i];
                int largestIndex = i;
                for (int j = i+1; j < array.length; j++) {
                    if (array[j] > largest) {
                        largestIndex = j;
                        largest = array[j];
                    }
                }
                array[largestIndex] = array[i];
                array[i] = largest;
            }
        }
        return array;
    }

    private static Integer[] bubbleSortAsc(final Integer[] array) {
        if (array != null && array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                boolean swapped = false;
                for (int j = 0; j < array.length - (i + 1); j++) {
                    if (array[j] > array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
        }
        return array;
    }

    private static Integer[] bubbleSortDesc(final Integer[] array) {
        if (array != null && array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                boolean swapped = false;
                for (int j = 0; j < array.length - (i + 1); j++) {
                    if (array[j] < array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
        }
        return array;
    }

    private static Integer[] quickSortAsc(final Integer[] array, final int low, final int high) {

        if (low < high) {
            int pivot = low + ((high - low) / 2);
            final int pivotalElement = array[pivot];
            array[pivot] = array[high];
            array[high] = pivotalElement;
            int leftIndex = low;
            int rightIndex = high - 1;
            while (leftIndex < rightIndex) {
                while (leftIndex < rightIndex && array[leftIndex] < pivotalElement) {
                    leftIndex++;
                }
                while (rightIndex > leftIndex && array[rightIndex] > pivotalElement) {
                    rightIndex--;
                }
                swap(array, leftIndex, rightIndex);
            }
            final Integer item = array[leftIndex];
            if (item > pivotalElement) {
                pivot = leftIndex;
            } else {
                pivot = leftIndex + 1;
            }
            swap(array, pivot, high);
            quickSortAsc(array, low, pivot-1);
            quickSortAsc(array, pivot+1, high);
        }
        return array;
    }

    private static Integer[] quickSortDesc(final Integer[] array, final int low, final int high) {

        if (low < high) {
            int pivot = low + ((high - low) / 2);
            final int pivotalElement = array[pivot];
            array[pivot] = array[high];
            array[high] = pivotalElement;
            int leftIndex = low;
            int rightIndex = high - 1;
            while (leftIndex < rightIndex) {
                while (leftIndex < rightIndex && array[leftIndex] > pivotalElement) {
                    leftIndex++;
                }
                while (rightIndex > leftIndex && array[rightIndex] < pivotalElement) {
                    rightIndex--;
                }
                swap(array, leftIndex, rightIndex);
            }
            final Integer item = array[leftIndex];
            if (item > pivotalElement) {
                pivot = leftIndex + 1;
            } else {
                pivot = leftIndex;
            }
            swap(array, pivot, high);
            quickSortDesc(array, low, pivot-1);
            quickSortDesc(array, pivot+1, high);
        }
        return array;
    }

    private static void swap(final Integer[] array, final int index1, final int index2) {
        final int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static String getStringDisplayTill(final Integer[] array, final int beginIndex, final int endIndex) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = beginIndex; i <= endIndex; i++) {
            stringBuilder.append(array[i]).append(" ");
        }
        return stringBuilder.toString();
    }
}
