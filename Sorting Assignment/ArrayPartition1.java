// Problem:- https://leetcode.com/problems/array-partition-i

import java.util.Arrays;

public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return arraySum(nums);
    }
    
    public static int arraySum(int[] nums) {
        int maxSum = 0;
        
        for(int i = 0; i<nums.length; i+=2) {
            maxSum += nums[i];
        }
        
        return maxSum;
    }
}
