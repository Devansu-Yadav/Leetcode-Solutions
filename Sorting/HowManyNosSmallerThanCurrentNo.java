class HowManyNosSmallerThanCurrentNo {
    // T.C: Worst case - O(sum(arr)) where arr.length <= sum(arr) < arr.length^2
    // Space Complexity: O(max(arr))
    public int[] smallerNumbersThanCurrentUnoptimizedSol(int[] nums) {
        int max = findMax(nums);
        int[] count = new int[max + 1];
        int[] output = new int[nums.length];

        // Storing counts in count[] array
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]] += 1;
        }

        for(int j = 0; j < nums.length; j++) {
            int k = nums[j] - 1;
            int smallerNosCount = 0;
            while(k >= 0) {
                if(count[k] != 0) {
                    smallerNosCount += count[k];
                }
                k--;
            }
            output[j] = smallerNosCount;
        }
        return output;
    }

    // T.C: O(max(N, max(arr))), Space Complexity: O(max(arr))
    public int[] smallerNumbersThanCurrentOptimizedSol(int[] nums) {
        int max = findMax(nums);
        int[] count = new int[max + 1];
        int[] output = new int[nums.length];

        // Storing counts in count[] array
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]] += 1;
        }

        for(int j = 1; j < count.length; j++) {
            count[j] += count[j-1];
        }

        for(int k = 0; k < nums.length; k++) {
            if(nums[k] == 0) {
                output[k] = 0;
            } else {
                output[k] = count[nums[k] - 1];
            }
        }
        return output;
    }

    public static int findMax(int[] arr) {
        int max = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }    
}
