package Stack;

import java.util.Stack;

public class FindWarmerTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        return findWarmerTemp(temperatures);
    }

    // Brute Force Solution. T.C: O(n^2), S.C: O(1);
    public static int[] findWarmerTemp(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            while(j < temperatures.length && temperatures[j] <= temperatures[i]) {
                j++;
            }

            if(j < temperatures.length) {
                answer[i] = j - i;
            } else {
                answer[i] = 0; 
            }
        }
        return answer;
    }

    public static int[] findWarmerTempBetterSol(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }
}
