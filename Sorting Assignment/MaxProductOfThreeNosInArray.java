// Problem:- https://leetcode.com/problems/maximum-product-of-three-numbers/

import java.util.Arrays;
import java.lang.Math;

public class MaxProductOfThreeNosInArray {
    public int maximumProduct(int[] nums) {
        return maxProduct(nums);
    }
    
    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int lastIndex = nums.length - 1;
        return Math.max(Math.max(nums[lastIndex] * nums[lastIndex - 1] * nums[lastIndex - 2], nums[0] * nums[1] * nums[2]), Math.max(nums[0] * nums[1] * nums[lastIndex], nums[0] * nums[lastIndex] * nums[lastIndex - 1]));
    }
}
