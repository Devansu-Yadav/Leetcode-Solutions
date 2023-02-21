// T.C: O(alphaNumericStr.length()), Space Complexity: O(N)
// Better Solution: https://leetcode.com/problems/valid-palindrome/solutions/40291/java-9ms-solution-with-some-of-my-thoughts/

class ValidPalindrome {
    public boolean isPalindromeUsingTwoPointers(String s) {
        char[] c = s.toCharArray();

        String alphaNumericStr = new String("");
        for(int i = 0; i < c.length; i++) {
            if(Character.isLetter(c[i])) {
                alphaNumericStr += String.valueOf(Character.toLowerCase(c[i]));
            } else if(Character.isDigit(c[i])) {
                alphaNumericStr += String.valueOf(c[i]);
            }
        }

        if(alphaNumericStr.length() == 0) {
            return true;
        }

        int start = 0;
        int end = alphaNumericStr.length() - 1;
        while(start <= end) {
            if(alphaNumericStr.charAt(start) != alphaNumericStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }    
}
