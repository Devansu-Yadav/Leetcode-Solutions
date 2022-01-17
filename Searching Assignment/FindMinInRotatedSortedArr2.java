// Problem:- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
// Solution:- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48808/My-pretty-simple-code-to-solve-it

import java.util.SortedSet;
import java.util.TreeSet;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Arrays;

public class FindMinInRotatedSortedArr2 {
    public int findMin(int[] nums) {
        // return findMinimum1(nums);
        return findMinimum2(nums);
    }
    
    // Naive solution using Built-ins (Not Recruiter friendly:))
    // T.C - O(NlogN) Space Complexity - O(N)
    public static int findMinimum1(int[] nums) {
        SortedSet<Integer> s = new TreeSet<Integer>();
        
        for(int i = 0; i<nums.length; i++) {
            s.add(nums[i]);
        }
        
        return s.first();
    }

    // Better solution
    // T.C - O(N) Space complexity - O(N)
    public static int findMinimum2(int[] nums) {
        Set<Integer> s = new LinkedHashSet<Integer>();
        
        for(int i = 0; i<nums.length; i++) {
            s.add(nums[i]);
        }
        
        Integer[] arr = new Integer[s.size()];
        arr = s.toArray(arr);
        
        int start = 0;
        int end = arr.length - 1;
        int lastIndex = arr.length - 1;
        
        if(arr.length == 1) {
            return arr[0];
        }
        
        System.out.println("Array - " + Arrays.toString(arr));
        
        while(start < end) {
            int mid = start + (end - start)/2;
            
            // This is the pivot element
            if(mid + 1 <= end && arr[mid] > arr[mid + 1]) {
                return arr[(mid % lastIndex) + 1];
            } else if(arr[mid] < arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(start % lastIndex == 0 && start != 0) {
            return arr[start % lastIndex];
        }
        return arr[(start % lastIndex) + 1];
    }
}
