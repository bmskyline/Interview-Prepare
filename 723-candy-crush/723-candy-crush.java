class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean clean = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length - 2; c++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && Math.abs(board[r][c+1]) == v && Math.abs(board[r][c+2]) == v) {
                    board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                    clean = true;
                }
            }
        }
        for (int r = 0; r < board.length - 2; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && Math.abs(board[r+1][c]) == v && Math.abs(board[r+2][c]) == v) {
                    board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                    clean = true;
                }
            }
        }
        
        for (int c = 0; c < board[0].length; c++) {
            int wr = board.length - 1;
            for (int r = board.length - 1; r >= 0; r--)
                if (board[r][c] > 0)
                    board[wr--][c] = board[r][c];
            while (wr >= 0)
                board[wr--][c] = 0;
        }
        return clean ? candyCrush(board) : board;
    }
}