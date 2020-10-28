package dsandalgos.sorting.insertionsort;

import dsandalgos.sorting.insertionsort.InsertionSort.SortOrder;

public class TestInsertionSort {

	public static void main(String[] args) {
		
		int[] arr = {6,5,10,9,11,1};
//		arr = InsertionSort.sortAscending(arr);
//		System.out.println("Sorted Array in ASCENDING order is:\n");
//		for(int item : arr) {
//			System.out.print(item);
//			System.out.print("\t");
//		}
//		System.out.println("\n\n");
//		arr = InsertionSort.sortDescending(arr);
//		System.out.println("Sorted Array in DESCENDING order is:\n");
//		for(int item : arr) {
//			System.out.print(item);
//			System.out.print("\t");
//		}
//		System.out.println();
		
		arr = InsertionSort.sortRecursively(arr, SortOrder.ASCENDING);
		System.out.println("Recursively Sorted Array:\n");
		for (int item : arr) {
			System.out.print(item + "\t");
		}
		System.out.println();
	}

}
