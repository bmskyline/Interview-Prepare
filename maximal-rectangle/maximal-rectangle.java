class Solution {
    public int maximalRectangle(char[][] matrix) {
        /*
        1 0 1 0 0
        1 0 1 2 3
        1 2 3 4 5
        1 0 0 1 0
        
        1 0 1 0 0
        2 0 2 1 1
        3 1 3 2 2
        4 0 0 3 0
        
        min(5,3) * 2
        min(1->3) *3
         
        */
        int n = matrix.length;
        if (n == 0)
            return 0;
        int m = matrix[0].length;
        int[][] row = new int[n][m];
        int[][] col = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    row[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '1') {
                        row[i][j] = row[i][j-1] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    col[j][i] = matrix[j][i] - '0';
                } else {
                    if (matrix[j][i] == '1') {
                        col[j][i] = col[j-1][i] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (col[i][j] > 0) {
                    int min = row[i][j];
                    for (int k = 1; k <= col[i][j]; k++) {
                        if (row[i - k + 1][j] < min) {
                            min = row[i - k + 1][j];
                        }
                        max = Math.max(max, min * k);
                    }
                }
            }
        }
        return max;
    }
}