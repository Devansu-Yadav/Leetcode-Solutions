// T.C: O(N), Space Complexity: O(1)

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1 && nums[0] != val) {
            return 1;
        }

        int i = 0;
        for(int n : nums) {
            if(n != val) {
                nums[i++] = n;
            }
        }
        return i;
    }    
}
