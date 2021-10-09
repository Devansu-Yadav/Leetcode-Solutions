// Problem:- https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

import java.util.Arrays;

public class SpecialArrayWithXElements {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        return specialNo(nums);
    }
    
    public static int specialNo(int[] nums) {
        int start = 0;
        int end = nums[nums.length - 1];
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            int count = isNoSpecial(mid, nums);
            
            if(count == mid) {
                return mid;
            } else if(count > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
    public static int isNoSpecial(int x, int[] nums) {
        int count = 0;
        
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] >= x) {
                count++;
            }
        }
        return count;
    }

    // Linear O(N) solution
    public static int crazyLinearSol(int[] nums) {
        int x = nums.length;
        int[] counts = new int[x+1];
        
        for(int elem : nums)
            if(elem >= x)
                counts[x]++;
            else
                counts[elem]++;
        
        int res = 0;
        for(int i = counts.length-1; i > 0; i--) {
            res += counts[i];
            if(res == i)
                return i;
        }
        
        return -1;
    }
}
