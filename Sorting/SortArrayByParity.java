// Problem:- https://leetcode.com/problems/sort-array-by-parity/

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        return sortedArr(nums);
    }
    
    public static void swapNos(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    
    public static int[] sortedArr(int[] nums) {
        int i = 0, j = nums.length - 1;
        
        while(i < j) {
            if(nums[i] % 2 != 0 && nums[j] % 2 == 0) {
                swapNos(i, j, nums);
            } else if(nums[i] % 2 != 0 && nums[j] % 2 != 0) {
                j--;
            } else if(nums[i] % 2 == 0 && nums[j] % 2 == 0) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return nums;
    }
}
