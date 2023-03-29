import java.lang.Math;

class MinLengthOfStrAfterDeletingSimilarEnds {
    // T.C:- O(N), Space Complexity: O(1)
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            // check if prefix and suffix are equal
            if(s.charAt(left) == s.charAt(right)) {
                // move left pointer till all chars in prefix are equal.
                while(left != right && s.charAt(left + 1) == s.charAt(left)) {
                    left++;
                }

                // move right pointer till all chars in suffix are equal.
                while(right != left && s.charAt(right - 1) == s.charAt(right)) {
                    right--;
                }
            } else {
                break;
            }

            if(left == right) {
                return 0;
            }
                 
            // selecting new prefix and suffix of the string
            left++;
            right--;
        }
        return (right - left) + 1;
    }

    // T.C: O(N), Space Complexity: O(1)
    public int minimumLengthCleanerSol(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            char c = s.charAt(left);

            // check if prefix and suffix are equal or not
            if(s.charAt(right) != c) {
                break;
            }

            // prefix and suffix are equal.
            // move left pointer till all chars in prefix are equal.
            while(left < right && s.charAt(left) == c) {
                left++;
            }

            // move right pointer till all chars in suffix are equal.
            while(left <= right && s.charAt(right) == c) {
                right--;
            }
        }
        // When left & right pointers would have intersected, we always want to return 0.
        return Math.max(0, right - left + 1);
    }
}
