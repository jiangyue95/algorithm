// LeetCode 121. Best Time to Buy and Sell Stock
// Tags: DP(Dynamic Programming)
package leetcode_121_besttimetobuyandsellstock;

public class Solution {
    public int maxProfit(int[] prices) {
        // Base case
        if (prices.length <= 1) {
            return 0;
        }

        int minBuy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }

        return maxProfit;
    }
}
