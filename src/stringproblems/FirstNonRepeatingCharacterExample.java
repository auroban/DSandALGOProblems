package stringproblems;

import java.util.Scanner;

/*
 * Given a String, find the first non-repeating character
 * URL: https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 */

public class FirstNonRepeatingCharacterExample {

	public static void main(String[] args) {
		
		System.out.println("Please enter a string");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		scanner.close();
		
		for (int i=0; i<string.length(); i++) {
			char ch = string.charAt(i);
			// occurrence = 1 because the character appears at least once in the String
			int occurrence = 1;
			for	(int j = 0; j < string.length(); j++) {
				if (j != i) {
					if (ch == string.charAt(j)) {
						occurrence++;
					}
					if (occurrence > 1) {
						break;
					}
				}
			}
			if (occurrence == 1) {
				System.out.println(ch);
				break;
			}
		}
	}

}
