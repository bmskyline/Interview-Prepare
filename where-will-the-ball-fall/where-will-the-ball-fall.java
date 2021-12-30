class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        Map<Integer, Integer> dp = new HashMap();
        for (int i = 0; i < res.length; i++) {
            res[i] = dfs(grid, 0, i, dp);
        }
        return res;
    }
    
    int dfs(int[][] grid, int row, int col, Map<Integer, Integer> dp) {
        if (row == grid.length)
            return col;
        int key = row * grid[0].length + col;
        if (dp.containsKey(key))
            return dp.get(key);
        if (grid[row][col] == 1) {
            if (col == grid[0].length - 1) {
                dp.put(key, -1);
            } else {
                if (grid[row][col + 1] == -1)
                    dp.put(key, -1);
                else dp.put(key, dfs(grid, row + 1, col + 1, dp));
            }
        } else {
            if (col == 0) {
                dp.put(key, -1);
            } else {
                if (grid[row][col - 1] == 1)
                    dp.put(key, -1);
                else dp.put(key, dfs(grid, row + 1, col - 1, dp));
            }
        }
        return dp.get(key);
    }
}