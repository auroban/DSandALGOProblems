package stringproblems;

import java.util.Scanner;

/* Reverse a sentence keeping the words unaltered.
 * Input --> "Hey there! How are you?"
 * Output --> "you? are How there! Hey"
 */

public class ReverseASentence {

	public static void main(String[] args) {
		
		System.out.println("Please enter the sentence:");
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		scanner.close();
		System.out.println("The reversed sentence is:\n" + reverseString(0, sentence.length()-1, sentence));

	}
	
	private static String reverseString(int firstIndex, int lastIndex, String sentence) {
		
		int firstPos = firstIndex;
		int lastPos = lastIndex;
		
		while (firstIndex < sentence.length() && sentence.charAt(firstIndex) != ' ') {
			if (firstIndex == lastIndex) {
				return sentence.substring(firstPos, firstIndex+1);
			}
			firstIndex++;
		}
		while (lastIndex > 0 && sentence.charAt(lastIndex) != ' ') {
			lastIndex--;
		}
		
		if (firstIndex < sentence.length() && lastIndex >0) {
			return sentence.substring(lastIndex+1, lastPos+1) + " " + reverseString(firstIndex+1, lastIndex-1, sentence) + " " + sentence.substring(firstPos, firstIndex);
		}
		return "";
				
	}

}
