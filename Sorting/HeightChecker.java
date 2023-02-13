
// TC: O(n + K) where K is the range from min to max value in array
// Space Complexity: O(n + K) where K is the range from min to max value in the array
// Better Solution: https://leetcode.com/problems/height-checker/solutions/300472/java-0ms-o-n-solution-no-need-to-sort/

class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        int max = findMax(heights);
        int[] count = new int[max];

        // storing counts
        for(int i = 0; i < heights.length; i++) {
            count[heights[i] - 1] += 1;
        }

        // finding and storing cumulative sum
        for(int j = 1; j < count.length; j++) {
            count[j] = count[j] + count[j-1];
        }

        for(int k = heights.length - 1; k >= 0; k--) {
            expected[count[heights[k] - 1] - 1] = heights[k];
            count[heights[k] - 1] -= 1;
        }

        return compareEqualSizeArrays(heights, expected);
    }

    public static int compareEqualSizeArrays(int[] a, int[] b) {
        int indices = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) {
                indices++;
            }
        }
        return indices;
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
