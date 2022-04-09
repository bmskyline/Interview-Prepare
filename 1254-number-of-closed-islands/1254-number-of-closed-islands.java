class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    if (checkClosedIsland(grid, r, c))
                        count++;
                }
            }
        }
        return count;
    }
    
    boolean checkClosedIsland(int[][] grid, int r, int c) {
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1) {
            return false;
        }
        if (grid[r][c] > 2) {
            return false;
        } else if (grid[r][c] >= 1) {
            return true;
        } else {
            grid[r][c] = 2;
            if (checkClosedIsland(grid, r - 1, c)
               && checkClosedIsland(grid, r + 1, c)
               && checkClosedIsland(grid, r, c - 1)
               && checkClosedIsland(grid, r, c + 1))
                return true;
            grid[r][c] = 3;
            return false;
        }
    }
}