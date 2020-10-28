package dsandalgos.sorting.selectionsort;

public class SelectionSort {

	public static int[] sortAscending(int[] arr) {

		if (arr.length > 1) {
			for (int i = 0; i < arr.length-1; i++) {
				int smallest = arr[i];
				for (int j = i + 1; j < (arr.length); j++) {
					if (arr[j] < smallest) {
						int temp = arr[j];
						smallest = temp;
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
			}
		}
		return arr;
	}

	public static int[] sortDescending(int[] arr) {

		if (arr.length > 1) {
			for (int i = 0; i < arr.length-1; i++) {
				int largest = arr[i];
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] > largest) {
						int temp = arr[j];
						largest = temp;
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
			}
		}
		return arr;
	}

}
