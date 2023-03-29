import java.util.Arrays;

// T.C: O(N^2), Space Complexity: O(1)
class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int maxScore = 0;

        int left = 0, right = tokens.length - 1;
        while(left < right) {
            if(power >= tokens[left]) {
                maxScore++;
                power -= tokens[left];
                left++;
            } else if(maxScore > 0) {
                maxScore--;
                power += tokens[right];
                right--;
            } else {
                break;
            }
        }

        if(left == right && power >= tokens[left]) {
            maxScore++;
        }
        return maxScore;
    }
}
