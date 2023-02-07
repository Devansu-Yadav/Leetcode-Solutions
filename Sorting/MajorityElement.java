// Problem:- https://leetcode.com/problems/majority-element/
// Solution:- https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation)

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


// Naive solution using HashMaps
// T.C - O(N), S.C - O(N)
public class MajorityElement {
    public int majorityElement(int[] nums) {
        return majorElement(nums);
    }
    
    public static int majorElement(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++) {
            if(!m.containsKey(nums[i])) {
                m.put(nums[i], 0);
            } else {
                m.put(nums[i], m.get(nums[i]) + 1);
            }
        }
        
        return Collections.max(m.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}