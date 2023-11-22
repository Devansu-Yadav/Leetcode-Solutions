import java.util.HashMap;

// T.C: O(m + n), Space Complexity: O(n)

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.get(t.charAt(i)) == null ? 1: map.get(t.charAt(i)) + 1);
        }

        int l = 0, r = 0;
        int max = Integer.MAX_VALUE;
        int count = map.size();

        while(r < s.length()) {
            if(r < s.length() && map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                if(map.get(s.charAt(r)) == 0) {
                    count--;
                }
            }
            
            while(count == 0) {
                if(r - l + 1 < max) {
                    max = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                if(map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    if(map.get(s.charAt(l)) == 1) {
                        count++;
                    }
                }
                l++;
            }
            r++;
        }
        return res;
    }
}
