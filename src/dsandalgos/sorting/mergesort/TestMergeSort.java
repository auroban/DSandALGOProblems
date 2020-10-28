package dsandalgos.sorting.mergesort;

class TestMergeSort {

	public static void main(String[] args) {
		
		int[] arr = {0,2,1,1,2,0,0};
		arr = MergeSort.mergeSort(arr);
		for (int item : arr) {
			System.out.print(item + "\t");
		}
	}

}
