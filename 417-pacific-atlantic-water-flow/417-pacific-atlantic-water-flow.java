class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] value = new int[row][col];
        bfs(heights, value, 1);
        bfs(heights, value, 2);
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (value[i][j] == 3) {
                    List<Integer> cell = new ArrayList();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        
        return res;
    }
    
    void bfs(int[][] h, int[][] v, int del) {
        boolean[][] visited = new boolean[v.length][v[0].length];
        Deque<Integer> rows = new ArrayDeque();
        Deque<Integer> cols = new ArrayDeque();
        int[][] vector = {{0,1},{1,0},{-1,0},{0,-1}};
        if (del == 1) {
            for (int i = 0; i < h.length; i++) {
                rows.add(i);
                cols.add(0);
                v[i][0] = v[i][0] | del;
                
            }
            for (int i = 0; i < h[0].length; i++) {
                cols.add(i);
                rows.add(0);
                v[0][i] = v[0][i] | del;
            }
        } else if (del == 2) {
            for (int i = 0; i < h.length;i++) {
                rows.add(i);
                cols.add(h[0].length - 1);
                v[i][h[0].length - 1] = v[i][h[0].length - 1] | del;
            }
            for (int i = 0; i < h[0].length;i++) {
                cols.add(i);
                rows.add(h.length - 1);
                v[h.length - 1][i] =v[h.length - 1][i] | del;
            }
        }
        
        while(!rows.isEmpty()) {
            int r = rows.poll();
            int c = cols.poll();
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nR = r + vector[i][0];
                int nC = c + vector[i][1];
                if (nR >= h.length || nR < 0 || nC < 0 || nC >= h[0].length || visited[nR][nC])
                    continue;
                if (h[nR][nC] >= h[r][c]) {
                    rows.add(nR);
                    cols.add(nC);
                    v[nR][nC] = v[nR][nC] | del;
                }
            }
        }
    }
    
    /*
    how can I save 2 value into 1
    P, A
    P
    A
    N
    
    n = 00
    a = 01
    p = 10
    pa = 11
    */
}