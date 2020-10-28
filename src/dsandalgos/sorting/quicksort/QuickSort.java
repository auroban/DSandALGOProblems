package dsandalgos.sorting.quicksort;

class QuickSort {

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotPosition = partition(arr, low, high);
			quickSort(arr, low, pivotPosition-1);
			quickSort(arr, pivotPosition + 1, high);
		}
	}

	/**
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return the pivot position
	 * 
	 * In the partition process, the middle element is selected as the pivot
	 * The pivot is then moved to index low of the array
	 * Two indices i and j are maintained and are initialized with low+1
	 * i always represent the position before which all the elements in the array are less than pivot
	 * j always looks for elements that are <= pivot
	 * At any point j finds an element > pivot, j moves on to the next element
	 * At any point j finds an element <= pivot, it swaps it with the position of the i,
	 * which is now pointing to an item > pivot.
	 * The swapping between arr[i] and arr[j] is done
	 * i increases by one and so does j
	 * 
	 * For more info: https://www.geeksforgeeks.org/java-program-for-quicksort/
	 * 
	 */
	private static int partition(int[] arr, int low, int high) {
		
		if (low == high) {
			return low;
		}
		if (low < high) {
			int pivot = (low + high) / 2;
			int pivotalItem = arr[pivot];
			swap(arr, low, pivot);

			int i = low + 1;
			int j = low + 1;
			
			for (; j <= high; j++)  {
				if (arr[j] <= pivotalItem) {
					swap(arr, i, j);
					i++;
				}
			}
			
			swap(arr, low, --i);
			return i;
//			int i = low + 1;
//			int j = high;

//			while (i <= j) {
//				while (i <= high && arr[i] < pivotalItem) {
//					i++;
//				}
//				while (j >= (low + 1) && arr[j] > pivotalItem) {
//					j--;
//				}
//				if (i <= j) {
//					swap(arr, i, j);
//					i++;
//					j--;
//				}
//			}
//			swap(arr, low, j);
//			return j;
		}
		return high;
	}

	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
