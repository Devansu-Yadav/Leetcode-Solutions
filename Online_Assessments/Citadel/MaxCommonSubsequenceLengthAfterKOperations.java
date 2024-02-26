package Online_Assessments.Citadel;

public class MaxCommonSubsequenceLengthAfterKOperations {
    public static void main(String[] args) {
        System.out.println(maxLCS("aamge", "basic", 8));
    }

    public static int maxLCS(String lotteryID, String winnerID, int k) {
        int m = lotteryID.length(), n = winnerID.length();
        int[][][] dp = new int[m+1][n+1][k+1];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                for (int op = 0; op <= k; op++) {
                    if (lotteryID.charAt(i) == winnerID.charAt(j)) {
                        dp[i][j][op] = 1 + dp[i+1][j+1][op];
                    } else {
                        dp[i][j][op] = Math.max(dp[i+1][j][op], dp[i][j+1][op]);
                        if (op > 0) {
                            int cost = Math.abs(lotteryID.charAt(i) - winnerID.charAt(j));
                            if (op >= cost) {
                                dp[i][j][op] = Math.max(dp[i][j][op], 1 + dp[i+1][j+1][op-cost]);
                            }
                        }
                    }
                }
            }
        }

        return dp[0][0][k];
    }
}
