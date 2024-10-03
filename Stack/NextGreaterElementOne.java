package Stack;

import java.util.Stack;

public class NextGreaterElementOne {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nextGreater(nums1, nums2);
    }

    // T.C: O(nums1.length + nums2.length), S.C: O(nums2.length)
    public static int[] nextGreater(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        int[] temp = new int[10000];
        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                temp[nums2[i]] = -1;
            } else {
                temp[nums2[i]] = stack.peek();
            }
            stack.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++) {
            arr[i] = temp[nums1[i]];
        }
        return arr;
    }
}
