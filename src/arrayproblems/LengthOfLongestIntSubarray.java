package arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author auro
 * 
 *         Given an array of Integers and an item K, find out the longest
 *         sub-array where every element is greater than K
 * 
 *         Ex 1:
 *         Input: Array => [0,2,5,3,4,6,9,1,10,5,1], K = 3
 *         Output: 3
 *         Explanation: The possible sub-arrays where every element > K are [5],
 *         [4,6,9], [10,5] Max length is 3 for the sub-array [4,6,9]
 * 
 *         Ex 2: Input: Array => [5,6,3,2,8], K = 6 Output: 1 Possible
 *         Sub-arrays: [6] and [8] Max length: 1
 * 
 *         For more info:
 *         https://www.geeksforgeeks.org/longest-subarray-in-which-all-elements-are-greater-than-k/
 *
 */

class LengthOfLongestIntSubarray {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 9, 1, 5, 6, 3, 1, 0, 2, 5 };
		int k = 3;
		LengthOfLongestIntSubarray l = new LengthOfLongestIntSubarray();
		System.out.println(l.findLengthOfLongestSubarray(arr, k));
		
		List<Integer[]> list = l.findPossibleSubarrays(arr, k);
		for (Integer[] arrr : list) {
			for (int a : arrr) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Solution: The idea is to maintain an index that marks the beginning of a
	 * possible sub-array and another that marks the end of the sub-array. We also
	 * need to maintain a variable length that will keep the max length of all
	 * possible sub-arrays
	 * 
	 * Length = endIndex - (beginIndex + 1)
	 * 
	 * Steps:
	 * ======
	 * 1. We initialize the three variables, beginIndex, endIndex and
	 * length with -1, -1 and 0 respectively
	 * 2. As soon we find an element n > K
	 * while iterating over the array, we mark both the indices with the iteration
	 * number and we update the length if it's greater than its current value
	 * 3. When another element n > K is found in the following iterations, we check if
	 * it's the immediate next element (endIndex + 1 == i). In case it is, we
	 * increase the value of endIndex by 1 and also update length in case it's
	 * greater than its current value
	 * 4. In case n <= K, we reset the indices with 	the value -1
	 * 5. We return whatever is the latest value of length
	 * 
	 * @param arr
	 * @param k
	 * @return length
	 */
	int findLengthOfLongestSubarray(int[] arr, int k) {
		int length = 0, beginIndex = -1, endIndex = -1;

		for (int i = 0; i < arr.length; i++) {
			int n = arr[i];
			if (n > k) {
				if (beginIndex < 0 && endIndex < 0) {
					beginIndex = i;
					endIndex = i;
				} else {
					endIndex++;
				}
				int len = endIndex - (beginIndex - 1);
				if (len > length) {
					length = len;
				}

			} else {
				beginIndex = -1;
				endIndex = -1;
			}
		}
		return length;
	}

	List<Integer[]> findPossibleSubarrays(int[] arr, int k) {

		List<Integer[]> listOfAllSubarrays = new ArrayList<Integer[]>();
		int beginIndex = -1, endIndex = -1;

		for (int i = 0; i < arr.length; i++) {			
			int n = arr[i];
			if (n > k) {
				if (beginIndex < 0 && endIndex < 0) {
					beginIndex = i;
					endIndex = i;
				} else {
					endIndex++;
				}
				if (i == arr.length - 1) {
					Integer[] subArr = Arrays.stream(subArray(arr, beginIndex, i+1)).boxed().toArray(Integer[]::new);
					listOfAllSubarrays.add(subArr);
				}
			} else {
				if (beginIndex > -1 && endIndex > -1) {
					Integer[] subArr = Arrays.stream(subArray(arr, beginIndex, i)).boxed().toArray(Integer[]::new);
					listOfAllSubarrays.add(subArr);
				}
				beginIndex = endIndex = -1;
			}
		}
		return listOfAllSubarrays;
	}

	private int[] subArray(int[] arr, int begin, int end) {
		int[] subArr = new int[end - begin];
		for (int i = begin, j = 0; i < end && j < subArr.length; i++, j++) {
			subArr[j] = arr[i];
		}
		return subArr;

	}

}
