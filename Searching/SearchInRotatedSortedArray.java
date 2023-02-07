public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        // System.out.println("Pivot " + pivot);
        
        if(pivot == -1) {
            return binarySearchArray(nums, target, 0, nums.length - 1);
        }
        
        if(target == nums[pivot]) {
            return pivot;
        } else if(target >= nums[0]) {
            return binarySearchArray(nums, target, 0, pivot - 1);
        }
        return binarySearchArray(nums, target, pivot + 1, nums.length-1);
    }
    
    public static int binarySearchArray(int[] nums, int target, int start, int end) {
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
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
            
            if(nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
