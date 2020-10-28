package leetcode.medium.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

class LongestSubstringWithoutRepeatingChar {

    public static int longestSubstring(final String string) {
        if (string == null || string.length() == 0 || string.length() > 50000) {
            return 0;
        }

        int maxLength = 0;
        int start = -1;
        int end = -1;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            final char c = string.charAt(i);

            if (map.containsKey(c)) {
                final int pos = map.get(c);
                start = pos + 1;
                end = i;
                map = new HashMap<>();
                for (int j = start; j < end; j++) {
                    map.put(string.charAt(j), j);
                }
                map.put(c, i);
            } else {
                map.put(c, i);
                if (start < 0) {
                    start = end = i;
                } else {
                    end = i;
                }
            }

            int length = end - start + 1;
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
