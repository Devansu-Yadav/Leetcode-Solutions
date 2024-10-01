package Stack;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        return removeDigits(num, k);
    }

    // T.C: O(N), S.C: O(N)
    public static String removeDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++) {
            while(!stack.isEmpty() && num.charAt(i) < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for(char c: stack) {
            if(c == '0' && sb.length() == 0) {
                continue;
            }
            sb.append(c);
        }

        return sb.length() == 0 ? "0": sb.toString();
    }
}
