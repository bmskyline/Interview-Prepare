class Solution {
    int MAX = 10000000;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] save = new int[m + 1][target + 1][n + 1];
        int min = Integer.MAX_VALUE;
        min = dfs(houses, cost, 0, target, 0, save);
        return min == MAX ? -1 : min;
    }
    
    int dfs(int[] houses, int[][] cost, int i, int target, int lastColor, int[][][] dp) {
        if (i >= houses.length || target < 0) 
            return target == 0 ? target : MAX;
        if (dp[i][target][lastColor] > 0)
            return dp[i][target][lastColor];
        
        if (houses[i] != 0)
            return dfs(houses, cost, i + 1, target - ((lastColor != houses[i]) ? 1 : 0), houses[i], dp);      
        
        int res = MAX;
        for (int clr = 1; clr <= cost[i].length; ++clr) {
            res = Math.min(res, cost[i][clr - 1] + dfs(houses, cost, i + 1, target - ((lastColor != clr) ? 1 : 0), clr, dp));
        }            
        
        return dp[i][target][lastColor] = res;
    }
}