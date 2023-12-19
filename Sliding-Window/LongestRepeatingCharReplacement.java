import java.util.HashMap;

// Better Solution with O(1) Space Complexity: https://leetcode.com/problems/longest-repeating-character-replacement/solutions/91271/java-12-lines-o-n-sliding-window-solution-with-explanation/
public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        return longestSubstringWithKDiffChars(s, k);
    }

    // TC: O(N), Space Complexity: O(N)
    public static int longestSubstringWithKDiffChars(String s, int k) {
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int maxRepeatedCharsCount = 0;

        while(r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxRepeatedCharsCount = Math.max(maxRepeatedCharsCount, map.get(s.charAt(r)));

            while(Math.abs(r - l + 1 - maxRepeatedCharsCount) > k) {
                maxLen = Math.max(maxLen, l == 0 ? r - l: r - l - 1);

                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }

        if(Math.abs(r - l - maxRepeatedCharsCount) <= k) {
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}
