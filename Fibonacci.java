import java.util.ArrayList;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("fibonacci with memo: " + fibobacci(10));
        System.out.println("fibonacci with DP: " + fibonacciWithDP(10));
        System.out.println("fibonacci with DP Perfect: " + fibonacciWithDPPerfect(10));
    }

    public static int fibobacci(int N) {
        if(N < 1) return 0;
        // 备忘录全初始化为 0
        ArrayList<Integer> memo = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) memo.add(0);
        return helper(memo, N);
    }

    public static int helper(ArrayList<Integer> memo, int n) {
        // base case
        if (n == 1 || n == 2) return 1;
        // Already caclulated
        if (memo.get(n) != 0) return memo.get(n);
        memo.set(n, helper(memo, n - 1) + helper(memo, n - 2));
        return memo.get(n);
    }

    public static int fibonacciWithDP(int n) {
        ArrayList<Integer> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) dp.add(0);
        dp.set(1, 1);
        dp.set(2, 1);
        for (int i = 3; i <= n; i++) {
            dp.set(i, dp.get(i - 1) + dp.get(i - 2));
        }
        return dp.get(n);
    }

    public static int fibonacciWithDPPerfect(int n) {
        if (n == 1 || n == 2) return 1;
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}