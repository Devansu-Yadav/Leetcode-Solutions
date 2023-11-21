// T.C: O(N), Space Complexity: O(1)

public class MinSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int min = nums.length + 1;

        while(right < nums.length) {
            sum += nums[right];

            while(sum >= target) {
                min = Math.min(min, right - left + 1);

                sum -= nums[left];
                left += 1;
            }
            right += 1;
        }

        if(sum >= target) {
            min = Math.min(min, right - left + 1);
        }
        return min < nums.length + 1 ? min: 0;
    }
}
