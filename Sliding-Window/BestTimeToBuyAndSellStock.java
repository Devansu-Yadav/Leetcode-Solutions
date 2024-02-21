// T.C: O(N), Space Complexity: O(1)

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        return maximiseProfit(prices);
    }

    public static int maximiseProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;

        while(r < prices.length) {
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);

            while(prices[r] - prices[l] < 0) {
                l++;
            }
            r++;
        }

        return maxProfit;
    }
}
