package Stack;

import java.util.Stack;

public class NextGreaterElementTwo {
    // T.C: O(N), S.C: O(N)
    public int[] nextGreaterElements(int[] nums) {
        return nextGreater(nums);
    }

    public static int[] nextGreater(int[] nums) {
        int[] arr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*nums.length - 1; i >= 0; i--) {
            int idx = i % nums.length;
            while(!stack.isEmpty() && stack.peek() <= nums[idx]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                arr[idx] = -1;
            } else {
                arr[idx] = stack.peek();
            }
            stack.push(nums[idx]);
        }
        return arr;
    }
}
