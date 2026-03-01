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
        // create a array of int and its length is amount + 1
        // PS. dp is the abbreviation for Dynamic Programming
        int[] dp = new int[amount + 1];
        // Initialize the value of dp as amount + 1
        // amount + 1 is an impossible value for thie problem
        // hence, this value can be used to check whether a answer for the question
        Arrays.fill(dp, amount + 1);
        
        // if amount is 0, answer is 0
        dp[0] = 0;
        // for loop begins for 1
        for (int i = 1; i < dp.length; i++) {
            // for loop try each type of coins
            for (int j = 0; j < coins.length; j++) {
                // if target is lower than the value of coin
                if (i - coins[j] < 0) {
                    // do nothing
                    continue;
                }
                // core code: transfer the problem into small value
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        // use amount + 1 check whether there is an value
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
