class Solution {
    int[][] v = new int[][]{{-1, 0}, {1, 0}, {0, -1},{0, 1}};
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int l = 0;
        int r = Math.min(grid[0][0], grid[m-1][n-1]);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (dfs(grid, 0, 0, mid, new boolean[m][n])) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return dfs(grid, 0, 0, l, new boolean[m][n]) ? l : l - 1;
    }
    
    boolean dfs(int[][] grid, int r, int c, int min, boolean[][] visited) {
        if (r == grid.length - 1 && c == grid[0].length -1) {
            return grid[r][c] >= min;
        }
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1
           || visited[r][c] || grid[r][c] < min)
            return false;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            if (dfs(grid, r + v[i][0], c + v[i][1], Math.min(min, Math.abs(grid[r][c])), visited))
                return true;
        }
        return false;
    }
}