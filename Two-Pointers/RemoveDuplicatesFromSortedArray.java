// T.C: O(N^2), as for making each element unique we have to traverse till the end of the array.
// Space Complexity: O(1)
// Better Solution: https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/11780/5-lines-c-java-nicer-loops/

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        int garbageVal = -101;
        int i = 0;
        int j = i + 1;

        while(nums[i] != garbageVal && j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            } else {
                if(j != i + 1) {
                    // shift the elements in array by j - i positions
                    shiftElements(nums, j, j-i-1, garbageVal);
                }
                // nums[i] is now a unique element
                i++;
                j = i + 1;
            }
        }
        if(j == nums.length && nums[i] != garbageVal) {
            return i + 1;
        }
        return i;
    }

    public static void shiftElements(int[] arr, int idx, int shift, int garbageVal) {
        for(int i = idx; i < arr.length; i++) {
            arr[i - shift] = arr[i];
            arr[i] = garbageVal;
        }

        // ensuring all duplicate elements are set to garbageVal
        if(shift > arr.length - idx) {
            for(int j = arr.length - shift; j < idx; j++) {
                arr[j] = garbageVal;
            }
        }
    }    
}
