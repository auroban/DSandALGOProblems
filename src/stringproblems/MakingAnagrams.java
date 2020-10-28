package stringproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class MakingAnagrams {

	public static void main(String[] args) {
		
		System.out.print("Please enter the two strings:\t");
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.next();
		String string2 = scanner.next();
		scanner.close();
		if (string1.length() >= 1 && string2.length() >= 1 && string1.length() <= 10000 && string2.length() <= 10000) {
			if (string1.equals(string1.toLowerCase()) && string2.equals(string2.toLowerCase())) {
				char[] charArray1 = string1.toCharArray();
				char[] charArray2 = string2.toCharArray();
				ArrayList<Character> charArrayList = new ArrayList<Character>(); 
				
				for (int i = 0; i < charArray1.length; i++) {
					for	(int j = 0; j < charArray2.length; j++) {
						if (charArray1[i] == charArray2[j]) {
							charArrayList.add(charArray2[j]);
							charArray2[j] = ' ';
							break;
						}
					}
				}
				
				System.out.println("Size of string1: " + string1.length());
				System.out.println("Size of string2: " + string2.length());
				System.out.println("Size of Char ArrayList: " + charArrayList.size());
				int numOfCharToTrim = (string1.length() - charArrayList.size()) + (string2.length() - charArrayList.size());
				System.out.println(numOfCharToTrim);
			}
			else {
				System.out.println("String not in lower case");
			}
		}
		else {
			System.out.println("String lengths out of range");
		}
	}

}
