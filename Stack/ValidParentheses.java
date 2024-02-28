package Stack;

import java.util.Stack;

// T.C: O(N), S.C: O(N)
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == ')') {
                if(chars.empty() || !chars.peek().equals('(')) {
                    return false;
                } 
                chars.pop();
            } else if(ch == ']') {
                if(chars.empty() || !chars.peek().equals('[')) {
                    return false;
                }
                chars.pop();
            } else if(ch == '}') {
                if(chars.empty() || !chars.peek().equals('{')) {
                    return false;
                }
                chars.pop();
            } else {
                chars.push(ch);
            }
        }

        return chars.empty();
    }
}
