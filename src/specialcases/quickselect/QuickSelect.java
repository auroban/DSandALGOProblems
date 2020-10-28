package specialcases.quickselect;

class QuickSelect {

	public int quickSelect(int[] arr, int k) {
		if (k <= arr.length) {
			return quickSelect(arr, 0, (arr.length - 1), k);
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param k - the i-th smallest element to find
	 * @return the i-th smallest element
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
	 * Once partitioned completely, the algorithm checks and performs the following:
	 * 1. If position of the item being searched == pivot index, return pivot element
	 * 2. If position of the item being searched < pivot index, search the left part of the pivot (low to pivot-1)
	 * 3. If position of the item being searched > pivot index, search the right part of the pivot (pivot+1 to high)
	 * 
	 */
	private int quickSelect(int[] arr, int low, int high, int k) {
		if (low == high) {
			return arr[low];
		}
		if (low < high) {
			int pivotIndex = (low + high) / 2;
			swap(arr, low, pivotIndex);
			int pivot = arr[low];
			int i = low + 1;
			int j = low + 1;
			for (; j <= high; j++) {
				if (arr[j] <= pivot) {
					swap(arr, i, j);
					i++;
				}
			}
			swap(arr, low, --i);
			pivotIndex = i;
			if (pivotIndex == (k - 1)) {
				return arr[pivotIndex];
			} else if (pivotIndex < (k - 1)) {
				return quickSelect(arr, pivotIndex + 1, high, k);
			} else {
				return quickSelect(arr, low, pivotIndex - 1, k);
			}
		}
		return arr[high];
	}

	private void swap(int[] arr, int index1, int index2) {
		int temp = arr[index2];
		arr[index2] = arr[index1];
		arr[index1] = temp;
	}

}
