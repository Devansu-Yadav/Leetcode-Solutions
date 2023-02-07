// Problem:- https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class findFirstAndLastIndexElement {
    public int[] searchRange(int[] nums, int target) {
        return binarySearchOnRange(nums, target);
    }
    
    public static int[] binarySearchOnRange(int[] nums, int target) {
        int[] pos = new int[2];
        int startIndex = -1;
        int endIndex = -1;
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                startIndex = mid;
                end = mid - 1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if(startIndex == -1) {
            pos[0] = -1;
            pos[1] = -1;
            return pos;
        }
        
        start = startIndex + 1;
        end = nums.length - 1;
        
        while(start <= end) {
            int midIndex = start + (end - start)/2;
            
            if(nums[midIndex] == target) {
                endIndex = midIndex;
                start = midIndex + 1;
            } else if(nums[midIndex] < target) {
                start = midIndex + 1;
            } else {
                end = midIndex - 1;
            }
        }
        
        pos[0] = startIndex;
        
        if(endIndex == -1) {
            pos[1] = startIndex;
        } else {
            pos[1] = endIndex;   
        }
        
        return pos;
    }
}
