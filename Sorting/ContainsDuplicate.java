// Problem:- https://leetcode.com/problems/contains-duplicate/
// Solution:- https://leetcode.com/problems/contains-duplicate/discuss/60937/3ms-Java-Solution-with-Bit-Manipulation

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

// Short and easy solution
// T.C:- O(N) and S.C:- O(N)
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        return containsDuplicateElements(nums);
    }
    
    public static boolean containsDuplicateElements(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        Set<Integer> s = new HashSet<>(Arrays.asList(arr));
        
        return s.size() < nums.length;
    }
}
