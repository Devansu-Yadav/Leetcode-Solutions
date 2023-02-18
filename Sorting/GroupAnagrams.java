import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// T.C: O(N), Space Complexity: O(N)
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            String sortedStr = sortString(s);
            if(map.containsKey(sortedStr)) {
                List<String> anagram = map.get(sortedStr);
                anagram.add(s);
                map.put(sortedStr, anagram);
            } else {
                map.put(sortedStr, new ArrayList<String>(List.of(s)));
            }
        }

        List<List<String>> result = new ArrayList<List<String>>(map.values());
        return result;
    }

    public static String sortString(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}
