class Solution {
    public int maximalSquare(char[][] m) {
        int max = 0;
        int[][] table = new int[m.length+1][m[0].length+1];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == '0')
                    table[i+1][j+1] = 0;
                else {
                    table[i+1][j+1] = Math.min(table[i][j+1], Math.min(table[i][j], table[i+1][j])) + 1;
                    if (table[i+1][j+1] > max)
                        max = table[i+1][j+1];
                }
            }
        }
        return max*max;
    }
    /*
    Time complexity : O(m*n)
    Space complexity : O(m*n)
    */
}