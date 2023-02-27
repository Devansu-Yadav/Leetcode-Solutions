// T.C: O(t.length()), Space Complexity: O(1)
// Follow up ques solution: https://leetcode.com/problems/is-subsequence/solutions/87302/binary-search-solution-for-follow-up-with-detailed-comments/
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) {
            return false;
        } else if(s.length() == 0 && t.length() != 0) {
            return true;
        }

        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()) {
            if(t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }

        if(i == s.length()) {
            return true;
        }
        return false;
    }
}