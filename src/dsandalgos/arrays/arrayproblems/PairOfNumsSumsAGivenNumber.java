package dsandalgos.arrays.arrayproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 * Given an integer array A[] and a number X, find out all the pairs in the array that sum up to the given number.
 * Time Complexity requirement: O(n)
 * 
 *  URL: https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 *  
 *  
 *  The idea here is to use a HashSet
 *  Step 1: Iterate over the array 
 *  Step 2: For each element arr[i] in the array, check if X - arr[i] belongs to HashSet
 *  Step 3: If it does, print arr[i] and the element in the HashSet
 *  
 *  In this way, only one iteration happens over the array, hence the time complexity of O(n)
 *  
 */
public class PairOfNumsSumsAGivenNumber {

	public static void main(String[] args) {

		System.out.println("Please enter the array elements:");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			arrayList.add(scanner.nextInt());
		}
		System.out.println("Please enter the Sum number:");
		scanner.close();
		int x = 30;
		int[] intArray = arrayList.stream().mapToInt(Integer::intValue).toArray();
		HashSet<Pair> pairs = findPairs(intArray, x);
		if (pairs.size() > 0) {
			for (Pair pair : pairs) {
				System.out.println("Pair:\t" + pair.first + " " + pair.second);
			}
		} else {
			System.out.println("No such pairs found");
		}
	}

	private static HashSet<Pair> findPairs(int[] intArray, int x) {

		HashSet<Integer> hashSet = new HashSet<Integer>();
		HashSet<Pair> pairs = new HashSet<Pair>();

		for (int i = 0; i < intArray.length; i++) {
			int bal = x - intArray[i];
			if (hashSet.contains(bal)) {
				Pair pair = new Pair();
				pair.first = bal;
				pair.second = intArray[i];
				pairs.add(pair);
			} else {
				hashSet.add(intArray[i]);
			}
		}

		return pairs;
	}

	private static class Pair {
		int first;
		int second;
	}

}
