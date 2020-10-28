package arrayproblems;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * We are given an array consisting of n elements. 
 * At each operation you can select any one element and increase rest of n-1 elements by 1. 
 * You have to make all elements equal performing such operation as many times you wish. 
 * Find the minimum number of operations needed for this.
 * URL: https://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/
 */



/*
 * Steps: - 
 * 
 * 1. Before every iteration, check if the elements in the array are already equal to each other. Time Complexity: O(n)
 *    Maintain a boolean to run the loop as long as all the elements are not equal.
 * 
 * 2. Find out the largest element and it's index in the array: Time Complexity: O(n)
 * 
 * 3. Iterate over the array incrementing the value of each element except for the largest element
 */
public class MinimumNoOfIncrementsToMakeArrayElementsEqual {

	public static void main(String[] args) {

		System.out.println("Please enter the array elements:");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			arrayList.add(scanner.nextInt());
		}
		scanner.close();
		
		int numberOfSteps = 0;
		boolean allEqual = false;
		
		if (arrayList.size() > 1) {
			while (!allEqual) {
			
				// This block finds out if all elements are equal
				int trueValue = 1;
				int num = arrayList.get(0);
				for (int i=0; i<arrayList.size();i++) {
					if (num == arrayList.get(i)) {
						trueValue = trueValue*1;
					}
					else {
						trueValue = trueValue*0;
					}
				}
				allEqual = (trueValue == 1);
				if (allEqual) {
					break;
				}
				
				// This block finds out the largest element and its index
				int largestElement = arrayList.get(0);
				int largestElementIndex = 0;
				for (int i=0; i<arrayList.size(); i++) {
					if (largestElement < arrayList.get(i)) {
						largestElement = arrayList.get(i);
						largestElementIndex = i;
					}
				}
				
				// This block does the actual increment of all the elements by 1 except for the largest element
				for (int i=0; i<arrayList.size(); i++) {
					if (i!=largestElementIndex) {
						int n = arrayList.get(i);
						arrayList.set(i, ++n);
					}
				}
				numberOfSteps++;
			}
		}
		System.out.println("The minimum number of steps required to make all the elements equal is: " + numberOfSteps);
	}

}
