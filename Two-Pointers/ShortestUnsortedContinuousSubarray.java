public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        return findUnsorted(nums);
    }

    // T.C: O(N), S.C: O(1)
    public static int findUnsorted(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }

        int min = nums[nums.length - 1];
        int max = nums[0];
        int beg = -1, end = -2;

        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < max) {
                end = i;
            }
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if(nums[i] > min) {
                beg = i;
            }
        }
        return end - beg + 1;
    }
}
