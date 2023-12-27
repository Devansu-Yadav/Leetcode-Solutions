public class RotateArray {
    // T.C: O(N), Space Complexity: O(1)
    public void rotate(int[] nums, int k) {
        int steps = k % nums.length;

        if(steps > 0) {
            reverseArr(nums, 0, nums.length - 1);
            reverseArr(nums, 0, steps - 1);
            reverseArr(nums, steps, nums.length - 1);
        }
    }

    public static void reverseArr(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
