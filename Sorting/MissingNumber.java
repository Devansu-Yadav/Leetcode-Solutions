// Problem:- https://leetcode.com/problems/missing-number

// T.C - O(N),  S.C - O(1)
public class MissingNumber {
    public int missingNumber(int[] nums) {
        return missingNo(nums);
    }
    
    public static int missingNo(int[] nums) {
        int i  = 0;
        
        while(i < nums.length) {
            int correctPos = nums[i];
            
            if(correctPos > nums.length - 1) {
                i++;
            }
            else if(nums[i] != nums[correctPos]) {
                swap(nums, i, correctPos);
            } else {
                i++;
            }
        }
        
        for(int j = 0; j<nums.length; j++) {
            int correct = nums[j];
            
            if(j != correct) {
                return j;
            }
        }
        return nums[nums.length - 1] + 1;
    }
    
    public static void swap(int[] nums, int i, int correctPos) {
        int temp = nums[i];
        nums[i] = nums[correctPos];
        nums[correctPos] = temp;
    }
}