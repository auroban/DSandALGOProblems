package dsandalgos.sorting.mergesort;

public class MergeSort {

	static int ITERATION = 1;

	public static int[] mergeSort(int[] arr) {

		int length = arr.length;
		if (length == 1) {
			return arr;
		}
		
		int[] sortedArray = new int[length];
		int mid = length / 2;

		int[] left = new int[mid];
		int[] right = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		
		for (int i = 0, j = mid; i < right.length && j < length; i++, j++) {
			right[i] = arr[j];
		}
	
		left = mergeSort(left);
		right = mergeSort(right);
		
		int indexLeft = 0, indexRight = 0, i = 0;

		while (indexLeft < left.length && indexRight < right.length) {
			if (left[indexLeft] < right[indexRight]) {
				sortedArray[i++] = left[indexLeft++];
			} else if (left[indexLeft] > right[indexRight]) {
				sortedArray[i++] = right[indexRight++];
			} else {
				sortedArray[i++] = left[indexLeft++];
				sortedArray[i++] = right[indexRight++];
			}
		}

		while (indexLeft < left.length) {
			sortedArray[i++] = left[indexLeft++];
		}

		while (indexRight < right.length) {
			sortedArray[i++] = right[indexRight++];
		}
		return sortedArray;
	}

}
