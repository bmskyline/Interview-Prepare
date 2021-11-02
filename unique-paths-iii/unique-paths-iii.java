class Solution {
    int count = 0;
    public int uniquePathsIII(int[][] grid) {
        /*
        calculate numbers of 0
        dfs from start 
        base case : reach the destination and count == to number of 0
        */
        int numsZero = 0;
        int rs = 0;
        int cs = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    numsZero++;
                } else if (grid[i][j] == 1) {
                    rs = i;
                    cs = j;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, visited, numsZero, 0, rs, cs);
        return count;
    }
    
    void dfs(int[][] grid, boolean[][] visited, int numsZero, int cur, int r, int c) {
        if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] == -1)
            return;
        if (grid[r][c] == 2) {
            if (cur == numsZero)
                count++;
            return;
        } 
        if (visited[r][c])
            return;
        visited[r][c] = true;
        if (grid[r][c] == 0) {
            cur++;
        }
        dfs(grid, visited, numsZero, cur, r+1, c);  
        dfs(grid, visited, numsZero, cur, r-1, c);  
        dfs(grid, visited, numsZero, cur, r, c+1);  
        dfs(grid, visited, numsZero, cur, r, c-1);
        visited[r][c] = false;
    }
    
    /*
    Time complexity : O(m*n)
    Space complexity : O(m*n)
    */
}