class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int x : coins) {
                if (i >= x && dp[i - x] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - x] +1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}