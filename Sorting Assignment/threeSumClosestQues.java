// Problem:- https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

// T.C:- O(N^2) Space Complexity - O(1)
public class threeSumClosestQues {
    public int threeSumClosest(int[] nums, int target) {
        return threeSumClosestSol(nums, target);
    }
    
    public static int threeSumClosestSol(int[] nums, int target) {
        if(nums.length < 3) {
            return -1;
        }
        
        Arrays.sort(nums);
        int minDiffThreeElems = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length - 2; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int twoSumClosest = twoSum(nums, i+1, nums.length - 1, target - nums[i]);
            if(Math.abs(nums[i] + twoSumClosest - target) < Math.abs(minDiffThreeElems)) {
                minDiffThreeElems = nums[i] + twoSumClosest - target;
            }
        }
        return minDiffThreeElems + target;
    }
    
    public static int twoSum(int[] nums, int low, int high, int target) {
        int minDiff = Integer.MAX_VALUE;
        while(low < high) {
            if(Math.abs(nums[low] + nums[high] - target) < Math.abs(minDiff)) {
                minDiff = nums[low] + nums[high] - target;
            }
            
            if(nums[low] + nums[high] == target) {
                minDiff = 0;
                break;
            } else if(nums[low] + nums[high] < target) {
                low ++;
            } else {
                high --;
            }
        }
        
        return minDiff + target;
    }
}
