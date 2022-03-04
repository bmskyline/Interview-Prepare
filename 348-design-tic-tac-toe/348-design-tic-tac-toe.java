class TicTacToe {

    int size;
    int[][] board;
    public TicTacToe(int n) {
        size = n;
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkHor(row, col, player))
            return player;
        if (checkVer(row, col, player))
            return player;
        if (check(row, col, player))
            return player;
        if (check1(row, col, player))
            return player;
        return 0;
    }
    
    boolean checkHor(int row, int col,int p) {
        int count = 1;
        int l = col - 1;
        int r = col + 1;
        while (l >= 0){
            if (board[row][l] != p) {
                break;
            }
            count++;
            l--;
        }
        while (r < size){
            if (board[row][r] != p) {
                break;
            }
            count++;
            r++;
        }
        return count == size;
    }
    
    boolean checkVer(int row, int col,int p) {
        int count = 1;
        int u = row - 1;
        int d = row + 1;
        while (u >= 0){
            if (board[u][col] != p) {
                break;
            }
            count++;
            u--;
        }
        while (d < size){
            if (board[d][col] != p) {
                break;
            }
            count++;
            d++;
        }
        return count == size;
    }
    
    boolean check(int row, int col,int p) {
        int count = 1;
        int r = row - 1;
        int c = col + 1;
        int r1 = row + 1;
        int c1 = col - 1;
        while (r >= 0 && c < size){
            if (board[r][c] != p) {
                break;
            }
            count++;
            r--;
            c++;
        }
        while (c1 >= 0 && r1 < size){
            if (board[r1][c1] != p) {
                break;
            }
            count++;
            r1++;
            c1--;
        }
        return count == size;
    }
    boolean check1(int row, int col,int p) {
        int count = 1;
        int r = row - 1;
        int c = col - 1;
        int r1 = row + 1;
        int c1 = col + 1;
        while (r >= 0 && c >= 0){
            if (board[r][c] != p) {
                break;
            }
            count++;
            r--;
            c--;
        }
        while (c1 < size && r1 < size){
            if (board[r1][c1] != p) {
                break;
            }
            count++;
            r1++;
            c1++;
        }
        return count == size;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */