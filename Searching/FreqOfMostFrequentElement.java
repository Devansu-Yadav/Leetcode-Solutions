// Problem:- https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Solution:- https://leetcode.com/problems/frequency-of-the-most-frequent-element/discuss/1175181/JavaPython-Prefix-Sum-and-Binary-Search-O(NlogN)

import java.util.Arrays;

public class FreqOfMostFrequentElement {
    static long[] preSum;
    
    public int maxFrequency(int[] nums, int k) {
        return maxFreq(nums, k);
    }
    
    public static int maxFreq(int[] nums, int k) {
        preSum = new long[nums.length + 1];
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];    
        }
        
        int ans = 0;
        for(int i = 0; i<nums.length; i++) {
            ans = Math.max(ans, countFreq(nums, i, k));
        }
        return ans;
    }
    
    public static long getSum(int from, int to) {
        return preSum[to + 1] - preSum[from];
    }
    
    public static int countFreq(int[] nums, int index, int k) {
        int left = 0, right = index, res = index;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            long sum = getSum(mid, index - 1);
            if(sum + k >= (long)(index - mid)*nums[index]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return index - res + 1;
    }
}
