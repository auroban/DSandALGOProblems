package dsandalgos.sorting.insertionsort;

public class InsertionSort {
	
	public enum SortOrder {
		ASCENDING, DESCENDING
	}

	public static int[] sortAscending(int[] arr) {

		if (arr.length > 1) {

			for (int i = 1; i < arr.length; i++) {
				int key = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = key;
			}
		}
		return arr;
	}

	public static int[] sortDescending(int[] arr) {
		if (arr.length > 1) {
			for (int i = 0; i < arr.length; i++) {
				int key = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] < key) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = key;
			}
		}
		return arr;
	}

	public static int[] sortRecursively(int[] arr, SortOrder sOrder) {
		if (arr.length > 1) {
			for (int i = 1; i < arr.length; i++) {
				int key = arr[i];
				int index = recursiveSort(i, key, arr);
				arr[index + 1] = key;
			}
		}
		return arr;
	}

	private static int recursiveSort(int index, int key, int[] arr) {
		int j = index - 1;
		if (j < 0)
			return -1;
		else {
			if (arr[j] > key) {
				arr[j + 1] = arr[j];
				return recursiveSort(j, key, arr);
			} else {
				return j;
			}
		}

	}
}
