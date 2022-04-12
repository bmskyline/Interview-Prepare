class Solution {
    
    public String alphabetBoardPath(String target) {
        String[] board = new String[] {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        StringBuilder res = new StringBuilder();
        int r = 0;
        int c = 0;
        for (int i = 0; i < target.length(); i++) {
            Result result = bfs(board, r, c, target.charAt(i));
            res.append(result.path.toString()).append("!");
            r = result.r;
            c = result.c;
        }
        return res.toString();
    }
    
    Result bfs(String[] board, int r, int c, char ch) {
        StringBuilder res = new StringBuilder();
        Deque<Result> queue = new ArrayDeque();
        queue.offer(new Result(r, c, res));
        int[] vR = new int[] {-1,1,0,0};
        int[] vC = new int[] {0,0,-1,1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Result cur = queue.poll();
                if (board[cur.r].charAt(cur.c) == ch) {
                    return cur;
                }
                for (int j = 0; j < 4; j++) {
                    int newR = cur.r + vR[j];
                    int newC = cur.c + vC[j];
                    StringBuilder str = new StringBuilder(cur.path);
                    switch(j) {
                        case 0:
                            str.append("U");
                            break;
                        case 1:
                            str.append("D");
                            break;
                        case 2:
                            str.append("L");
                            break;
                        case 3:
                            str.append("R");
                            break;
                    }
                    if (check(newR, newC)) {
                        queue.offer(new Result(newR, newC, str));
                    }
                }
            }
        }
        return new Result(0, 0, new StringBuilder());
    }
    
    boolean check(int r, int c) {
        if (r >= 0 && r <= 4 && c >=0 && c <= 4) {
            return true;
        } else if (r == 5 && c == 0) {
            return true;
        }
        return false;
    }
}

class Result {
    int r;
    int c;
    StringBuilder path;
    public Result(int r, int c, StringBuilder path) {
        this.r = r;
        this.c = c;
        this.path = path;
    }
}