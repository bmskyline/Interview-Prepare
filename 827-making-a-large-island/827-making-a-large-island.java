class Solution {
    public int largestIsland(int[][] grid) {
        /*
        1 0 0 0
        1 0 5 5
        1 0 5 0
        0 1 5 5.
        
        
        1 0
        0 1
        */
        int id = 2;
        Map<Integer, Integer> map = new HashMap();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid.length; c++) {
                if (grid[r][c] == 1) {
                    map.put(id, dfs(grid, id, r, c));
                    id++;
                }
            }
        }
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid.length; c++) {
                if (grid[r][c] == 0) {
                    max = Math.max(max, count(grid, r, c, map) + 1);
                }
            }
        }
        return max == 0 ? grid.length * grid.length : max;
    }
    
    int count(int[][] grid, int row, int col, Map<Integer, Integer> map) {
        Set<Integer> set = new HashSet();
        if (row > 0) {
            set.add(grid[row - 1][col]);
        }
        if (col > 0) {
            set.add(grid[row][col - 1]);
        }
        if (row + 1 < grid.length) {
            set.add(grid[row + 1][col]);
        }
        if (col + 1 < grid.length) {
            set.add(grid[row][col + 1]);
        }
        int count = 0;
        for (int x : set) {
            count += map.getOrDefault(x, 0);
        }
        return count;
    }
    
    int dfs(int[][] grid, int id, int row, int col) {
        if (row < 0 || row > grid.length - 1 ||col < 0 || col > grid.length - 1 
            || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = id;
        int count = 0;
        count += dfs(grid, id, row + 1, col);
        count += dfs(grid, id, row, col + 1);
        count += dfs(grid, id, row - 1, col);
        count += dfs(grid, id, row, col - 1);
        return count + 1;
    }
}