class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i] = dfs(grid, 0, i, dp);
        }
        return res;
    }
    
    int dfs(int[][] grid, int row, int col, Integer[][] dp) {
        if (row == grid.length)
            return col;
        if (dp[row][col] != null)
            return dp[row][col];
        if (grid[row][col] == 1) {
            if (col == grid[0].length - 1) {
                dp[row][col] = -1;
            } else {
                if (grid[row][col + 1] == -1)
                    dp[row][col] = -1;
                else dp[row][col] = dfs(grid, row + 1, col + 1, dp);
            }
        } else {
            if (col == 0) {
                dp[row][col] = -1;
            } else {
                if (grid[row][col - 1] == 1)
                    dp[row][col] = -1;
                else dp[row][col] = dfs(grid, row + 1, col - 1, dp);
            }
        }
        return dp[row][col];
    }
}