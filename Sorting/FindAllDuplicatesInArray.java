import java.util.List;
import java.util.ArrayList;

// TC: O(N), Space Complexity: O(1) extra space (ignoring output list space)
class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicateNos = new ArrayList<>();
        
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
                duplicateNos.add(nums[j]);
            }
        }
        return duplicateNos;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
