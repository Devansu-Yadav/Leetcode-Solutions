// Problem:- https://leetcode.com/problems/find-the-duplicate-number/
// Best Solution:- https://leetcode.com/problems/find-the-duplicate-number/discuss/72979/Java-O(1)-space-O(nlgn)-time-solution

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        return findDuplicateElement(nums);
    }
    
    public static int findDuplicateElement(int[] nums) {
        int i = 0;
        int ans = -1;
        while(i < nums.length) {
            if(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else if(nums[i] == nums[nums[i] - 1] && i != nums[i] - 1) {
                ans = nums[i];
                break;
            } else {
                i++;
            }
        }
        return ans;
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}