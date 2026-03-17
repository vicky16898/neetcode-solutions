package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> countS = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int have = 0;
        int need = countT.size();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            if (countS.get(s.charAt(i)) == countT.get(s.charAt(i))) {
                have++;
            }

            while (have == need) {
                if (minLength > i - left + 1) {
                    minLength = i - left + 1;
                    res = s.substring(left, i + 1);
                }
                countS.put(s.charAt(left), countS.get(s.charAt(left)) - 1);
                if (countT.containsKey(s.charAt(left)) && countS.get(s.charAt(left)) + 1 == countT.get(s.charAt(left)))
                    have--;
                left++;
            }
        }
        return res;

    }
}
