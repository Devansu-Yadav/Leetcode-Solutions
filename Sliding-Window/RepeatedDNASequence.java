import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// TC: O(N), Space Complexity: O(N)
// Better Solution: https://leetcode.com/problems/repeated-dna-sequences/solutions/53867/clean-java-solution-hashmap-bits-manipulation/

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i <= s.length() - 10; i++) {
            map.put(s.substring(i, i+10), map.getOrDefault(s.substring(i, i+10), 0) + 1);
        }

        for(String k: map.keySet()) {
            if(map.get(k) > 1) {
                res.add(k);
            }
        }
        return res;
    }
}
