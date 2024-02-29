package Stack;

import java.util.Stack;

// T.C: O(N), S.C: O(N)
public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens) {
            switch(token) {
                case "+": {
                    int no2 = stack.pop();
                    int no1 = stack.pop();

                    stack.push(no1 + no2);
                    break;
                }
                case "-": {
                    int no2 = stack.pop();
                    int no1 = stack.pop();

                    stack.push(no1 - no2);
                    break;
                }
                case "*": {
                    int no2 = stack.pop();
                    int no1 = stack.pop();

                    stack.push(no1 * no2);
                    break;
                }
                case "/": {
                    int no2 = stack.pop();
                    int no1 = stack.pop();

                    stack.push(no1 / no2);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                    break;
                }
            }
        }
        return stack.peek();
    }
}
