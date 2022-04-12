class Solution {
    public void gameOfLife(int[][] board) {
        /*
        1 -> 0 if  < 2 or > 3 live neighbor, 
        1 -> 1 if 2 or 3 live neighbor
        0 -> 1 if 3 live neightbor
        
        0: 00
        1: 01 -> 1
        2: 10 -> 0
        3: 11 -> 1
        
         */
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0 && countNeighbor(board, i, j) == 3) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 1 && countNeighbor(board, i, j) <= 3 && countNeighbor(board, i, j) >= 2) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 1 && (countNeighbor(board, i, j) < 2 || countNeighbor(board, i, j) > 3)) {
                    board[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j]>>1;
            }
        }
    }
    
    int countNeighbor(int[][] board, int i, int j) {
        int count = 0;
        if (i > 0 && j > 0 && (board[i-1][j-1] == 1 || board[i-1][j-1] == 3))
            count++;
        if (i > 0 && (board[i-1][j] == 1 || board[i-1][j] == 3))
            count++;
        if (i > 0 && j + 1 < board[0].length && (board[i-1][j+1] == 1 || board[i-1][j+1] == 3))
            count++;
        if (j > 0 && (board[i][j-1] == 1 || board[i][j-1] == 3))
            count++;
        if (j + 1 < board[0].length && (board[i][j+1] == 1 || board[i][j+1] == 3))
            count++;
        if (i + 1 < board.length && j > 0 && (board[i+1][j-1] == 1 || board[i+1][j-1] == 3))
            count++;
        if (i + 1 < board.length && (board[i+1][j] == 1 || board[i+1][j] == 3))
            count++;
        if (i + 1 < board.length && j + 1 < board[0].length && (board[i+1][j+1] == 1 || board[i+1][j+1] == 3))
            count++;   
        return count;
    }
}