package arrayproblems;

import dsandalgos.sorting.mergesort.MergeSort;

public class SortArrayZeroOneTwo {

	public static void main(String[] args) {
		
		int[] arr = {2,1,0,2,2,1,0};
		arr = MergeSort.mergeSort(arr);
		for (int item : arr) {
			System.out.print(item + "\t");
		}

	}

}
