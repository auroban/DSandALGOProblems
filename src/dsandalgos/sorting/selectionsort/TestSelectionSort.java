package dsandalgos.sorting.selectionsort;

public class TestSelectionSort {

	public static void main(String[] args) {

		int[] arr = { 5, 6, 1, 11, 10, 12, 9 };
		arr = SelectionSort.sortAscending(arr);
		System.out.println("Sorting in ASCENDING order:\n");
		for (int item : arr) {
			System.out.print(item + "\t");
		}
		System.out.println("\n\n");
		System.out.println("Sorting in DESCENDING order:\n");
		arr = SelectionSort.sortDescending(arr);
		for (int item : arr) {
			System.out.print(item + "\t");
		}
	}

}
