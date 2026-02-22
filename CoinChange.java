public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amount = 11;
        System.out.println("Coin number: " + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int res = Integer.MAX_VALUE;

        if(amount == 0) return 0;
        if(amount < 0) return -1;

        for (int i = 0; i < coins.length; i++){
            int subProblem = coinChange(coins, amount-coins[i]);
            if(subProblem == -1) continue;
            res = Math.min(res, 1 + subProblem);
        }
        return (res != Integer.MAX_VALUE)? res : -1;
    }
}