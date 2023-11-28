import java.util.TreeSet;

// TC: O(Nlog(indexDiff)), Space Complexity: O(indexDiff)
// Solution Reference: https://www.youtube.com/watch?v=DUPwzvuI4vQ

public class ContainsDuplicateThree {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(nums.length == 0 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            Long floor = set.floor(Long.valueOf(nums[i] + valueDiff));
            Long ceil = set.ceiling(Long.valueOf(nums[i] - valueDiff));

            if(floor != null && floor >= nums[i] || ceil != null && ceil <= nums[i]) {
                return true;
            }
            set.add(Long.valueOf(nums[i]));

            if(i >= indexDiff) {
                set.remove(Long.valueOf(nums[i - indexDiff]));
            }
        }

        return false;
    }
}
