// Problem:- https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        return findChar(letters, target);
    }
    
    public static char findChar(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        
        while(start < end) {
            int mid = start + (end - start)/2;
            
            if(letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if(letters[start] <= target) {
            return letters[(end+1) % letters.length];
        }
        return letters[end];
    }
}
