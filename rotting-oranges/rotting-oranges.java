class Solution {
    public int orangesRotting(int[][] grid) {
        /*
        brute force : cal rotten orange every minute
        improve solution :
        - count the orange
        - bread first search until reach all orange
        
        how many rotten orange
        */
        ArrayDeque<Integer> row = new ArrayDeque();
        ArrayDeque<Integer> col = new ArrayDeque();
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    row.offer(i);
                    col.offer(j);
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0)
            return 0;
        int countRot = 0;
        int res = 0;
        while (!row.isEmpty()) {
            int size = row.size();
            for (int i = 0; i < size; i++) {
                int r = row.poll();
                int c = col.poll();
                if (r + 1 < m && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    countRot++;
                    row.offer(r+1);
                    col.offer(c);
                }
                if (r > 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    countRot++;
                    row.offer(r-1);
                    col.offer(c);
                }
                if (c + 1 < n && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    countRot++;
                    row.offer(r);
                    col.offer(c+1);
                }
                if (c > 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    countRot++;
                    row.offer(r);
                    col.offer(c-1);
                }
            }
            res++;
            if (countRot == count)
                break;
        }
        return countRot == count ? res : -1;
    }
    /*
    Time complexity : O(m*n)
    Space complexity : O(m*n)
    */
}