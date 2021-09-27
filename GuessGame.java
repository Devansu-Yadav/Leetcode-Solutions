// Problem:- https://leetcode.com/problems/guess-number-higher-or-lower/

public class GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        
        while(true) {
            int mid = start + (end - start)/2;
            int guessed_no = guess(mid);
            if(guessed_no == 0) {
                return mid;
            } else if(guessed_no > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}