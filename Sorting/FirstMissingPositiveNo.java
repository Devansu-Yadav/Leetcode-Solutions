
// TC: O(N), Space Complexity: O(1)
class FirstMissingPositiveNo {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] <= 0 || nums[i] > nums.length) {
                i++;
                continue;
            }

            int correctIdx = nums[i] - 1;

            if(nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(j != nums[j] - 1) {
                return j+1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
