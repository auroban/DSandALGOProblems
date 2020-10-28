package stringproblems;

import java.util.HashMap;

/**
 * 
 * @author auro 
 * 
 * 		   Given a string, find out if it's a Pangram or not. A PANGRAM is
 *         a string that contains all the letters of the alphabet
 * 
 *         Ex1: "Are you ab cd, ef, gh, ij, kl, mn, op, qr, st, uv, wxyz" --> is
 *         a PANGRAM 
 *         Ex2: "Are you an idiot" --> is NOT a PANGRAM
 * 
 * 
 *         Solution: 
 *         1. Use a HashMap of Character and Boolean where each
 *         Character is a key and true/false is the value 
 *         2. Initialize that HashMap with false for all the keys 
 *         (This operation take O(1) time since it's for a fixed 
 *         number of characters) 
 *         3. Iterate over the string and find out if the character 
 *         exists in the map (Time taken O(n)) 
 *         4. If the character does exist, find out its boolean value 
 *         5. If the value is false, replace that with true 
 *         6. Once the string is completely iterated, check the map 
 *         for a false value (This operation takes O(1) since number 
 *         of search operations is fixed to the number of characters)
 * 
 */

public class PangramString {

	public static void main(String... args) {

		final String string = "Are you ab cd, ef, gh, ij, kl, mn, op, qr, st, uv, wxyz";
		System.out.println("\n\nUltimate Result:\t" + (isAPangram(string)));
	}

	/**
	 * 
	 * @param string
	 * @return a boolean value depending on whether the String is a Pangram or not
	 */
	private static boolean isAPangram(final String string) {

		HashMap<Character, Boolean> alphabet = new HashMap<Character, Boolean>();
		boolean isNotAPangram = true;

		for (int i = 97; i <= 122; i++) {
			char ch = (char) i;
			Character character = ch;
			alphabet.put(character, false);
		}

		for (int i = 0; i < string.length(); i++) {
			char key = string.charAt(i);
			if (alphabet.containsKey(key)) {
				boolean val = alphabet.get(key).booleanValue();
				if (!val) {
					alphabet.replace(key, true);
				}
			}
		}

		isNotAPangram = alphabet.containsValue(false);
		return !isNotAPangram;
	}

}
