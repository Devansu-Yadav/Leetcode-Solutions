// Problem:- https://leetcode.com/problems/assign-cookies
import java.util.Arrays;

// T.C:- O(glogg) or O(slogs)
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        return noOfContentChildren(g,s);
    }
    
    public static int noOfContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0;
        for(int cookie = 0; child<g.length && cookie<s.length; cookie++) {
            if(g[child] <= s[cookie]) {
                child++;
            }
        }
        return child;
    }
}
