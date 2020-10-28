package numberproblems;


import java.util.Scanner;

/**
 *
 * @see https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
 *
 */

public class MinNumWithIncrementDecrementPattern {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a pattern in terms of I (for Increment) and D (for Decrement)");
		String pattern = scanner.next();
		if (pattern.length() > 8) {
			System.out.println("Invalid Range");
		}
		else {
			System.out.println("The minimum number is:\t" + findMinNumWithPattern(pattern));
		}
		scanner.close();
	}
	
	private static String findMinNumWithPattern(String pattern) {
		
		// currentMax always keeps a track of the maximum number currently in the sequence
		// lastEntry always keeps a track of the last entered number
		int currentMax = 0, lastEntry = 0;
		String result = "";
		for (int i = 0; i < pattern.length(); i++) {
			int j = 0;
			int noOfD = 0;
			switch (pattern.charAt(i)) {
			case 'I':
				j = i + 1;
				noOfD = 0;
				//This loop checks how many Ds are there after the current element, the value of the next element in incremented to the number of Ds + 1
				// Hence if there are three Ds, the incremented element has to be be 6 so that the seq follows as 6 5 4 3 
				while (j < pattern.length() && pattern.charAt(j) == 'D') {
					noOfD++;
					j++;
				}
				if (noOfD == 0) {
					if (i == 0) {
						currentMax = 2;
						result = result + 1 + currentMax;
						lastEntry = currentMax;
					}
					else {
						currentMax++;
						result = result + currentMax;
						lastEntry = currentMax;
					}
				}
				else {
					currentMax = currentMax + noOfD + 1;
					result = result + currentMax;
					lastEntry = currentMax;
				}
				break;
			case 'D':
				j = i + 1; 
				noOfD = 0;
				while (j < pattern.length() && pattern.charAt(j) == 'D') {
					j++;
					noOfD++;
				}
				if (noOfD == 0) {
					if (i == 0) {
						currentMax = 2;
						lastEntry = 1;
						result = result + currentMax + lastEntry;
						System.out.println(result);
					}
					else {
						lastEntry = lastEntry - 1;
						result = result + lastEntry;
					}
				}
				else {
					// Special case here. If the seq starts with D (DDI....), there has to be 3 numbers for two Ds. Hence currentMax (0) + noOfD + 2
					if (i == 0) {
						currentMax = currentMax + noOfD + 2;
						lastEntry = currentMax - 1;
						result = result + currentMax + lastEntry;
					}
					else {
						lastEntry = lastEntry - 1;
						result = result + lastEntry;
					}
				}
				break;
			}
			
		}
		return result;
	}

}
