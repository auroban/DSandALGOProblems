package stringproblems.lengthoflastword;

import java.util.Optional;

public class LengthOfLastWord {
	
	public static int lengthOfLastWord(String string) {
		
		Optional<String> stringValue = Optional.ofNullable(string);
		
		if (!stringValue.isPresent()) {
			return 0;
		}
		
		int lengthOfString = string.length();
		
		int count = 0, i = lengthOfString-1;
		
		while (i >= 0) {
			char c = string.charAt(i);
			if (c == ' ') {
				break;
			}
			if ((c >= 'a' && c<='z') || (c>='A' && c<='Z')) {
				count++;	
			}
			i--;
		}
		
		return count;
	}

}
