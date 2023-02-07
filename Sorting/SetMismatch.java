class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
 
        int i = 0;
        while(i < nums.length) {
            int correctIdx = nums[i] - 1;

            if(nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }
 
        for(int j = 0; j < nums.length; j++) {
            if(j != nums[j] - 1) {
                ans[0] = nums[j];
                ans[1] = j+1;
                break;
            }
        }
        return ans;
    }
 
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
