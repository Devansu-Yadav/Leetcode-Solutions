package Stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class RemoveDupLetters {
    public String removeDuplicateLetters(String s) {
        return removeDupChars(s);
    }

    // T.C: O(N), S.C: O(1)
    public static String removeDupChars(String s) {
        Stack<Character> stack = new Stack<>();

        HashSet<Character> set = new HashSet<>();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!set.contains(c)) {
                while(!stack.isEmpty() && stack.peek() > c && 
                map.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                stack.push(c);
                set.add(c);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for(char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}