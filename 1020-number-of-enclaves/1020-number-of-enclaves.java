class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            if (grid[r][0] == 1)
                dfs(grid, r, 0);
        }
        for (int r = 0; r < grid.length; r++) {
            if (grid[r][grid[0].length - 1] == 1)
                dfs(grid, r, grid[0].length - 1);
        }
        for (int c = 1; c < grid[0].length; c++) {
            if (grid[0][c] == 1)
                dfs(grid, 0, c);
        }
        for (int c = 1; c < grid[0].length; c++) {
            if (grid[grid.length - 1][c] == 1)
                dfs(grid, grid.length - 1, c);
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col <0 || col >= grid[0].length || grid[row][col] > 1)
            return;
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
            return;
        }
        grid[row][col] = 2;
    }
}