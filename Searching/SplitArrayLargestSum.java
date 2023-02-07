import java.util.Arrays;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        return splitArrayLargestSum(nums, m);
    }
    
    public static int splitArrayLargestSum(int[] nums, int m) {
        int start = maxValueArray(nums);
        int end = Arrays.stream(nums).sum();
        
        while(start != end) {
            int mid = start + ((end - start) / 2);
            int currentPieces = piecesOfsplittedArray(nums, mid);
            
            if(currentPieces <= m) {
                end = mid;
            } else if(currentPieces > m) {
                start = mid + 1;
            }
        }
        return start;
    }
    
    public static int piecesOfsplittedArray(int[] nums, int sumOfPiece) {
        int partitions = 0;
        int currentSum = 0;
        for(int i = 0; i<nums.length; i++) {
            if(currentSum + nums[i] <= sumOfPiece) {
                currentSum += nums[i];
            }
            else if(currentSum + nums[i] > sumOfPiece) {
                partitions += 1;
                currentSum = nums[i];
            }
        }
        return partitions + 1;
    }
    
    public static int maxValueArray(int[] nums) {
        int max = nums[0];
        
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
