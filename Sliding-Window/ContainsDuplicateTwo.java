import java.util.HashSet;

public class ContainsDuplicateTwo {
    // TC: O(n*k), Space Complexity: O(1)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j <= i + k && j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // TC: O(n), Space Complexity: O(n)
    public boolean containsNearbyDuplicateBetter(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;

        while(right < nums.length) {
            if(!set.add(nums[right])) {
                return true;
            }

            while(right == left + k) {
                set.remove(nums[left]);
                left++;
            }
            right++;
        }
        return false;
    }
}
