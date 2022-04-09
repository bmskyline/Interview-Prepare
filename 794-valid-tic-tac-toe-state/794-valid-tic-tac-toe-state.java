class Solution {
    public boolean validTicTacToe(String[] board) {
        /*
        valid : 
        * x == o
        x cannot win
        o can win or not
        * o + 1
        x can win or not
        o cannot win
        */
        int countX = 0;
        int countO = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r].charAt(c) == 'X') {
                    countX++;
                } else if (board[r].charAt(c) == 'O') {
                    countO++;
                }
            }
        }
        if (countX == countO) {
            return checkWin(board, 'X') ? false : true;
        } else if (countX == countO + 1) {
            return checkWin(board, 'O') ? false : true;
        }
        return false;
    }
    
    boolean checkWin(String[] board, char c) {
        for (int r = 0; r < 3; r++) {
            if (board[r].charAt(0) == c 
                && board[r].charAt(1) == c 
                && board[r].charAt(2) == c)
                return true;
        }
        for (int r = 0; r < 3; r++) {
            if (board[0].charAt(r) == c 
                && board[1].charAt(r) == c 
                && board[2].charAt(r) == c)
                return true;
        }
        if (board[0].charAt(0) == c
           && board[1].charAt(1) == c
           && board[2].charAt(2) == c)
            return true;
        if (board[0].charAt(2) == c
           && board[1].charAt(1) == c
           && board[2].charAt(0) == c)
            return true;
        return false;
    }
}