// T.C: O(N), Space Complexity: O(1) since we always use an extra array of length 3
// Uses modified/simplified version of count sort
class SortColors {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for(int n : nums) {
            count[n]++;
        }

        int idx = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] != 0) {
                nums[idx++] = i;
                count[i]--;
            }
        }
    }
}
