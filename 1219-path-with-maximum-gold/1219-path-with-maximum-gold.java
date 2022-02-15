class Solution {
    public int getMaximumGold(int[][] grid) {
        /*
        
        0   6   0
        5   8   7
        0   9   0
        
        1 0 7
        2 0 6
        3 4 5
        0 3 0
        9 0 20
        */
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    
    int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == 0)
            return 0;
        int save = grid[row][col];
        grid[row][col] = 0;
            
        int sum1 = dfs(grid, row - 1, col);
        int sum2 = dfs(grid, row + 1, col);
        int sum3 = dfs(grid, row, col - 1);
        int sum4 = dfs(grid, row, col + 1);
        grid[row][col] = save;
        return Math.max(sum1, Math.max(sum2, Math.max(sum3, sum4))) + grid[row][col];
    }
}