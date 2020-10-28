package dsandalgos.sorting.quicksort;

class TestQuickSort {

	public static void main(String[] args) {

		int[] arr = { 5, 3, 0, 1, 1, 8, 9, 6, 16, -1 };
//		int[] arr = { 5, 3, 6, 1, 2, 9 };
//		int[] arr = { 1, 2, 0, 1 };
		System.out.println("Before Sorting:\n");
		for (int item : arr) {
			System.out.print(item + "\t");
		}
		System.out.println();
		QuickSort.quickSort(arr);
		System.out.println("After Sorting:\n");
		for (int item : arr) {
			System.out.print(item + "\t");
		}
		System.out.println();
	}

}
