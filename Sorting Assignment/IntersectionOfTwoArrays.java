// Problem:- https://leetcode.com/problems/intersection-of-two-arrays/
// My Solution for the second variation of this ques - https://leetcode.com/submissions/detail/566200525/
// External Sorting concept video for Follow-up question in (https://leetcode.com/problems/intersection-of-two-arrays-ii/) - https://www.youtube.com/watch?v=Bp7fGofslng

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

// T.C:- O(N), S.C:- O(N)
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        return intersectionArrays(nums1, nums2);
    }
    
    public static int[] intersectionArrays(int[] nums1, int[] nums2) {
        Integer[] arr1 = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
        Integer[] arr2 = Arrays.stream(nums2).boxed().toArray(Integer[]::new);
        
        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));
        
        set1.retainAll(set2);
        
        Integer[] outputArr = new Integer[set1.size()];
        outputArr = set1.toArray(outputArr);
        int[] answerArr = Arrays.stream(outputArr).mapToInt(Integer::intValue).toArray();
        return answerArr;
    }
}
