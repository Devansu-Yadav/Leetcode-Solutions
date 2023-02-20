import java.lang.Math;

// T.C: O(N), Space Complexity: O(max(arr) - min(arr))
// Better Solutions: https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/60591/a-few-ac-solutions-in-java-with-one-having-o-n-worst-time-complexity-with-explanation/
// & https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/60312/ac-clean-quickselect-java-solution-avg-o-n-time/
class KthLargestNo {
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length) {
            return -1;
        }

        int[] minMax = findMinMax(nums);
        int min = minMax[0];
        int max = minMax[1];
        int ans = Integer.MAX_VALUE;

        if(min == max) {
            ans = max;
            return ans;
        }

        if(min >= 0) {
            int[] count = new int[max + 1];
            for(int i : nums) {
                count[i]++;
            }

            for(int j = count.length - 1; j >= 0; j--) {
                while(count[j] != 0 && k != 0) {
                    count[j]--;
                    k--;
                }

                if(k == 0) {
                    ans = j;
                    break;
                }
            }
        } else {
            int[] count = new int[max - min + 1];
            for(int i : nums) {
                count[i + Math.abs(min)]++;
            }

            for(int j = count.length - 1; j >= 0; j--) {
                while(count[j] != 0 && k != 0) {
                    count[j]--;
                    k--;
                }

                if(k == 0) {
                    ans = j - Math.abs(min);
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] findMinMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int n : arr) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        return new int[] {min, max};
    }
}
