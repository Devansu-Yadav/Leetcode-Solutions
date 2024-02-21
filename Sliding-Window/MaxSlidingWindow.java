import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

// T.C: O(N), Space Complexity: O(k)
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return findMaxSlidingWindow(nums, k);
    }

    public static int[] findMaxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int out[] = new int[nums.length - k + 1];
        int outIdx = 0;

        for(int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            if(i >= k - 1) {
                out[outIdx] = nums[dq.peek()];
                outIdx++;
            }
        }

        return out;
    }
}
