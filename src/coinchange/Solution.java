// LeetCode 322. Coin Change
package coinchange;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println("LeetCode 322. Coin Change");
        int[] nums = {1, 2, 5};
        int amount = 11;
        System.out.println("Coin number: " + coinChange(nums, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
