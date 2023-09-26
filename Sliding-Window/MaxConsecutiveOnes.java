import java.lang.Math;
 
class MaxConsecutiveOnes {
    // TC: O(n^2), Space Complexity: O(1)
    public int findMaxConsecutiveOnesNaiveSol(int[] nums) {
        int left = 0, right = 0;
        int count_max_ones = 0;
        
        while(right < nums.length) {
            while(nums[right] == 0) {
                count_max_ones = Math.max(count_max_ones, right - left);
                
                if(left > right) {
                    break;
                }
                left += 1;
            }
            right += 1;
        }

        if(nums[right - 1] != 0) {
            count_max_ones = Math.max(count_max_ones, right - left);
        }
        return count_max_ones;
    }

    // TC: O(N), Space Complexity: O(1)
    public int findMaxConsecutiveOnesBetterSol(int[] nums) {
        int left = 0, right = 0;
        int count_max_ones = 0;
        
        while(right < nums.length) {
            if(nums[right] == 0) {
                count_max_ones = Math.max(count_max_ones, right - left);
                left = right + 1;
            }
            right += 1;
        }

        if(nums[right - 1] != 0) {
            count_max_ones = Math.max(count_max_ones, right - left);
        }
        return count_max_ones;
    }
}