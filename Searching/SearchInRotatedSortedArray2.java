public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int pivot = getPivot(nums);
        // System.out.println("Pivot " + pivot);
        
        if(pivot == -1) {
            return binarySearchArray(nums, target, 0, nums.length - 1);
        }
        
        if(target == nums[pivot]) {
            return true;
        } else if(target >= nums[0]) {
            return binarySearchArray(nums, target, 0, pivot - 1);
        }
        return binarySearchArray(nums, target, pivot + 1, nums.length-1);
    }
    
    public static boolean binarySearchArray(int[] nums, int target, int start, int end) {
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public static int getPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + ((end - start)/2);
            if(mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if(mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            
            if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if(start + 1 < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                
                if(end - 1 > start && nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                
                end--;
            }
            
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
