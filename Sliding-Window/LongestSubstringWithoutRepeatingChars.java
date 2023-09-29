import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

// T.C: O(N), Space Complexity: O(N)
// Better Solution: https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/1729/11-line-simple-java-solution-o-n-with-explanation/

class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        int l = 0;
        int r = 0;
        int maxLen = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();

        while(r < s.length()) {
            char currentChar = s.charAt(r);

            if(!charCount.containsKey(currentChar)) {
                charCount.put(currentChar, 1);
            } else {
                charCount.put(currentChar, charCount.get(currentChar) + 1);
            }
            
            while(charCount.get(currentChar) == 2) {
                maxLen = Math.max(maxLen, r - l);

                if(s.charAt(l) == currentChar) {
                    charCount.put(currentChar, 1);
                } else {
                    charCount.put(s.charAt(l), 0);
                } 
                l++;
            }
            r++;
        }

        if(charCount.get(s.charAt(r - 1)) < 2) {
            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }
}