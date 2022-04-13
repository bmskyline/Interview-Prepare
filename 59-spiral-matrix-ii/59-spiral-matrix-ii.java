class Solution {
    public int[][] generateMatrix(int n) {
        int [][] mat = new int[n][n];
        if (n == 1) {
            mat[0][0] = 1;
            return mat;
        }
        int count = 1;
        int border = 1;
        int direction = 1;// 2 -> down , 3 -> r to left , 4 up
        int row = 0, col = 0;
        while (mat[row][col] == 0) {
            mat[row][col] = count;
            switch (direction) {
                case 1:
                    if (col < n - border) {
                        col += 1;
                    } else if (col == n - border){
                        row += 1;
                        direction = 2;
                    }
                    break;
                case 2:
                    if (row < n - border) {
                        row += 1;
                    } else if (row == n - border){
                        col -= 1;
                        direction = 3;
                    }
                    break;
                case 3:
                    if (col > border-1) {
                        col -= 1;
                    } else if (col == border-1){
                        row -= 1;
                        direction = 4;
                        border += 1;
                    }
                    break;
                case 4:
                    if (row > border-1) {
                        row -= 1;
                    } else if (row == border-1){
                        col += 1;
                        direction = 1;
                    }
                    break;
            }
            count += 1;
        }
        return mat;
    }
}