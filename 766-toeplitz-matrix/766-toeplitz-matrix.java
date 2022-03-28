class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] != matrix[r - Math.min(r, c)][c - Math.min(r, c)])
                    return false;
            }
        }
        return true;
    }
}