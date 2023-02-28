// T.C: O(m*n), Space Complexity: O(1)
// Better Solution using KMP Substring search algorithm: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/13024/o-m-n-and-o-mn-solutions/

class FindIdxOfFirstOccurenceInStr {
    // This is Brute Force solution
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) {
            return -1;
        }

        int startIdx = 0;
        int i = 0; // points to each char in needle
        int j = 0; // points to each char in haystack

        while(i < needle.length() && j < haystack.length()) {
            if(haystack.charAt(j) != needle.charAt(i)) {
                startIdx++;
                j = startIdx;
                i = 0;
            } else {
                i++;
                j++;
            }
        }

        if(i != needle.length()) {
            return -1;
        }
        return startIdx;
    }
}
