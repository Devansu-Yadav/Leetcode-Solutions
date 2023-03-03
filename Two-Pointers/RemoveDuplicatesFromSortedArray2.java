// T.C: ~O(N^2) due to shifting of elements, Space Complexity: O(1)
// Better Solution: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/solutions/27987/short-and-simple-java-solution-easy-to-understand/

class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        int k = nums.length - 1;
        int count = 1;
        int i = 0;
        int j = i + 1;

        while(j <= k) {
            if(nums[i] == nums[j]) {
                count++;
            } else {
                if(count > 2) {
                    // shift all elements upto k by count-2 positions.
                    shiftArr(nums, j, k, count - 2);
                    k -= (count - 2);
                    j -= (count - 2);
                }
                count = 1;
                i = j;
            }
            j++;
        }

        if(count > 2) {
            k -= (count - 2);
        }
        return k + 1;
    }

    public void shiftArr(int[] arr, int start, int end, int shift) {
        for(int idx = start; idx <= end; idx++) {
            arr[idx - shift] = arr[idx];
        }
    }
}