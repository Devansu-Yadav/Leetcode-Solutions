// Problem:- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return searchMin(nums);
    }
    
    public static int searchMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        int start = 0;
        int end = nums.length - 1;
        int lastIndex = nums.length - 1;
        
        while(start < end) {
            int mid = start + (end - start)/2;
            
            // This is the pivot element
            if(mid + 1 <= end && nums[mid] > nums[mid + 1]) {
                return nums[(mid % lastIndex) + 1];
            } else if(nums[mid] < nums[start]) {
                // System.out.println("Hello");
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(start % lastIndex == 0 && start != 0) {
            return nums[start % lastIndex];
        }
        return nums[(start % lastIndex) + 1];
    }
}
