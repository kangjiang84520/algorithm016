package No70;

public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        System.out.println(c.climbStairs(45));
    }
    public int climbStairs(int n) {
        return byDp(n);
    }

    /**
     * stupid recursive, time exceed
     * @param n
     * @return
     */
    private int byRecursive(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return byRecursive(n-1) + byRecursive(n-2);
    }

    private int byDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
