package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> fMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            fMap.put(s.charAt(i), fMap.getOrDefault(s.charAt(i), 0) + 1);
            while (fMap.get(s.charAt(i)) > 1) {
                fMap.put(s.charAt(left), fMap.get(s.charAt(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
