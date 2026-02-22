import java.util.HashMap;
import java.util.Map;

public class CoinChangeWithMemo {
    // 1. 定义 memo：key=剩余金额，value 最小硬币数
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amount = 11;
        System.out.println("Coin number: " + coinChangeWithMemo(coins, amount));
    }

    public static int coinChangeWithMemo(int[] coins, int amount) {
        // 2. 先查 memo，避免重复计算
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        // 3. 原始边界条件
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        // 4. 原始递归逻辑
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++){
            int subProblem = coinChangeWithMemo(coins, amount-coins[i]);
            if (subProblem == -1) continue;
            res = Math.min(res, 1 + subProblem);
        }

        // 5. 计算结果存入 memo
        int result = (res != Integer.MAX_VALUE)? res : -1;
        memo.put(amount, result);
        return result;
    }
}