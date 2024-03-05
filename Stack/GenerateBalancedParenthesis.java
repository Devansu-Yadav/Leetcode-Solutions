package Stack;

import java.util.List;
import java.util.ArrayList;


// T.C: O(2^2n), S.C*: O((4^n)/(n^(3/2)))
public class GenerateBalancedParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(list, "", 0, 0, n);
        return list;
    }

    public static void generate(List<String> list, String str, int open, int close, int max) {
        
        if(str.length() == max*2) {
            list.add(str);
            return;
        }

        if(open < max) {
            generate(list, str+"(", open+1, close, max);
        }
        if(close < open) {
            generate(list, str+")", open, close+1, max);
        }
    }
}
