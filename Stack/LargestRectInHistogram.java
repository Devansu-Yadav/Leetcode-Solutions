package Stack;

import java.util.Stack;

// T.C: O(N), S.C: O(N)
public class LargestRectInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int idx = top[0];
                int height = top[1];
                start = idx;
                maxArea = Math.max(maxArea, height * (i - idx));
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            int idx = top[0];
            int height = top[1];
            maxArea = Math.max(maxArea, height * (heights.length - idx));
        }
        return maxArea;
    }
}
