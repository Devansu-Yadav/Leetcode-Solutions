// Problem - https://leetcode.com/problems/single-element-in-a-sorted-array/

public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        return findNonDuplicateElement(nums);
    }
    
    public static int findNonDuplicateElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end) {
            int mid = start + (end - start)/2;
            
            if(mid % 2 == 1) {
                mid --;
            }
            
            if(nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 2;
            }
        }
        return nums[start];
    }
}
