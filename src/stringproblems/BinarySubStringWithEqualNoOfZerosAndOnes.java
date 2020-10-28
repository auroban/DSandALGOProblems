package stringproblems;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Given a Binary String, find the maximum length of the substring that will contain equal number of 0s and 1s
 * This example works for virtually any string
 * The idea is to store each character of the string in a HashMap with its number of occurrence.
 * Once that's done, find the character with smallest number of occurrence and multiply that with the number of unique characters
 * This will give the max length of the substring that will contain the equal number of every character 
 */
public class BinarySubStringWithEqualNoOfZerosAndOnes {

	public static void main(String[] args) {
		
		System.out.println("Please enter the binary string");
		Scanner scanner = new Scanner(System.in);
		String binString = scanner.next();
		scanner.close();
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
		
		for (char ch : binString.toCharArray()) {
			countMap.put(ch, countMap.containsKey(ch) ? countMap.get(ch) + 1 : 1);
		}
		int smallest = countMap.get(binString.charAt(0));
		Set<Entry<Character, Integer>> entrySet = countMap.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() < smallest) {
				smallest = entry.getValue();
			}
		}
		
		System.out.println("Max Substring Length:\t" + (smallest*countMap.size()));

	}

}
