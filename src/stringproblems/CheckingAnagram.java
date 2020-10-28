package stringproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckingAnagram {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter both the strings:");
		String string1 = scanner.next();
		String string2 = scanner.next();
		scanner.close();
		
		// Condition to check if both the strings are in lower case
		if (string1.equals(string1.toLowerCase()) && string2.equals(string2.toLowerCase())) {
			if (string1.length() != string2.length()) {
				System.out.println("NOT ANAGRAMS");
			}
			else {
				char[] charArray1 = string1.toCharArray();
				char[] charArray2 = string2.toCharArray();
				ArrayList<Character> charArrayList = new ArrayList<Character>();
				for (int i=0; i<charArray1.length; i++)
					for	(int j=0; j<charArray2.length; j++) {
						if (charArray1[i] == charArray2[j]) {
							charArray2[j] = '\0';
							charArrayList.add(charArray1[i]);
							break;
						}
					}
				if (charArrayList.size() == charArray1.length && charArrayList.size() == charArray2.length) {
					System.out.println("Both the strings are anagram");
				}
				else {
					System.out.println("NOT ANAGRAMS");
				}
			}
			
		}
		else {
			System.err.println("Strings have to be in lower case");
		}
	}

}
