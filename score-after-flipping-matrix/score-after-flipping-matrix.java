class Solution {
    public int matrixScore(int[][] grid) {
        /*
        3
        10
        12
        
        */
        int res = 0;
        boolean[] flip = new boolean[grid.length];
        for (int j = 0; j < grid.length; j++) {
            if (grid[j][0] == 0) {
                flip[j] = true;
            }
        }
        res = grid.length * (int) Math.pow(2, grid[0].length - 1);
        for (int i = 1; i < grid[0].length; i++) {
            int count = 0;
            for (int j = 0; j < grid.length; j++) {
                if ((grid[j][i] == 1 && !flip[j]) || (grid[j][i] == 0 && flip[j])) {
                    count++;
                }
            }
            res += Math.max(count, grid.length - count) * (int) Math.pow(2, grid[0].length - 1 - i);
        }
        return res;
    }
    /*
    Time complexity : O(m*n)
    Space complexity : O(m)
    */
}