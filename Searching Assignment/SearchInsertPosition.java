// Problem:- https://leetcode.com/problems/search-insert-position

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }
    
    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(start == end + 1) {
            return start;
        }
        return end;
    }
}
