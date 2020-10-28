package stringproblems.numberofsubstringsstartingwith1endingwith1;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary string, count number of substrings that start and end with 1
 * 
 * For example: Given a binary string, count number of substrings that start and
 * end with 1. For example, if the input string is “00100101”, then there are
 * three substrings “1001”, “100101” and “101”
 *
 * Link: https://www.geeksforgeeks.org/given-binary-string-count-number-substrings-start-end-1/
 */

class Test {

	public static void main(String[] args) {
		
		final String binaryString = "100100101";
		Test test = new Test();
		System.out.println(test.maxSubstrings(binaryString));
		List<String> strings = test.subStrings(binaryString);
		System.out.println("Found Substrings.....\n\n");
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	
	int maxSubstrings(final String binaryString) {
		
		List<Integer> indexList = new ArrayList<>();
		int maxSubstrings = 0;
		if (binaryString != null && binaryString.length() != 0) {
			for (int i = 0; i < binaryString.length(); i++) {
				if (binaryString.charAt(i) == '1') {
					indexList.add(i);
				}
			}
			for (int i = 0; i < indexList.size(); i++) {
				int diff = indexList.size() - (i+1);
				maxSubstrings = maxSubstrings + diff;
			}
		}
		return maxSubstrings;
	}
	
	List<String> subStrings(final String binaryString) {
		
		List<String> subStringList = new ArrayList<>();
		List<Integer> indexList = new ArrayList<>();

		if (binaryString != null && binaryString.length() != 0) {
			for (int i = 0; i < binaryString.length(); i++) {
				if (binaryString.charAt(i) == '1') {
					indexList.add(i);
				}
			}
			
			for (int i = 0; i < indexList.size(); i++) {
				int j = i+1;
				while (j < indexList.size()) {
					int start = indexList.get(i);
					int end = indexList.get(j);
					String str = binaryString.substring(start, end+1);
					subStringList.add(str);
					j++;
				}
			}
		}
		
		return subStringList;
	}

}
