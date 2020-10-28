package testground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test {

	public static void main(String[] args) {

		int[] arr = { 8, 2, 10, 1, 0, 23, 54, 14, 11, 15, 156, 326, 22, 1, 7, 16, 20, 32, 99, 100, 21 };
		Arrays.sort(arr);
		for (int item : arr) {
			System.out.print(item + "\t");
		}
		System.out.println();
		System.out.println("Size of array: " + arr.length);
		int numOfSubArrays = howManyMedianSubArrays(arr);
		
		System.out.println("Expected number of Arrays: " + numOfSubArrays);
		List<Integer[]> listOfSubArrays = new ArrayList<Integer[]>();
		int borderPoint = 0;
		for (int i = 0; i < numOfSubArrays && borderPoint < arr.length; i++) {
			int[] copiedArr = Arrays.copyOfRange(arr, borderPoint, borderPoint+5);
			borderPoint = borderPoint + 5;
			Integer[] intArr = new Integer[copiedArr.length];
			for (int j = 0; j < copiedArr.length; j++) {
				intArr[j] = copiedArr[j];
			}
			listOfSubArrays.add(intArr);
		}
		
		System.out.println("Actual num of Arrays: " + listOfSubArrays.size());
		for (Integer[] intArr : listOfSubArrays) {
			for (int item : intArr) {
				System.out.print(item + "\t");
			}
			System.out.println("\n\n");
		}
	}

	private static int howManyMedianSubArrays(int[] arr) {
		int n = 0;

		if ((arr.length % 5) == 0) {
			n = arr.length / 5;
		} else {
			n = (arr.length / 5) + 1;
		}

		return n;
	}
	
	
	
}
