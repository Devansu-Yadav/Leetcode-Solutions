import java.lang.Math;

class MaxConsecutiveOnesThree {
    // T.C: O(n), Space Complexity: O(1)
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int countMaxOnes = 0;
        int countOfZeroes = 0;

        while(r < nums.length) {
            if(nums[r] == 0) {
                countOfZeroes++;
            }

            while(countOfZeroes > k) {
                countMaxOnes = Math.max(countMaxOnes, r - l);

                if(nums[l] == 0) {
                    countOfZeroes--;
                }
                l++;
            }
            r++;
        }

        if(countOfZeroes <= k) {
            countMaxOnes = Math.max(countMaxOnes, r - l);
        }
        return countMaxOnes;
    }
}