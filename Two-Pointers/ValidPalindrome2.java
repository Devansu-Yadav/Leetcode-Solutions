// T.C: O(N), Space Complexity: O(1)

class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                int l = i;
                int r = j - 1;

                // Checking if substring from i to j-1 is palindrome or not 
                while(s.charAt(l) == s.charAt(r)) {
                    if(l >= r) {
                        return true;
                    }
                    l++;
                    r--;
                }

                l = i + 1;
                r = j;

                // Else checking if substring from i+1 to j is palindrome or not.
                while(s.charAt(l) == s.charAt(r)) {
                    if(l >= r) {
                        return true;
                    }
                    l++;
                    r--;
                }
                break;
            }
        }

        if(i < j) {
            return false;
        }
        return true;
    } 
}
