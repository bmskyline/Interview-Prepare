class Solution {
    int[][] v = new int[][]{{-1,0}, {1,0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        List<Integer> rows = new ArrayList();
        List<Integer> cols = new ArrayList();
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }
        
        for (int i = 0; i < rows.size(); i++) {
            bfs(rooms, rows.get(i), cols.get(i));
        }
    }
    
    void bfs(int[][] rooms, int r, int c) {
        Deque<Integer> rQueue = new ArrayDeque();
        Deque<Integer> cQueue = new ArrayDeque();
        rQueue.offer(r);
        cQueue.offer(c);
        int dis = 0;
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        visited[r][c] = true;
        while (!rQueue.isEmpty()) {
            int size = rQueue.size();
            for (int i = 0; i < size; i++) {
                int curRow = rQueue.poll();
                int curCol = cQueue.poll();
                if (dis < rooms[curRow][curCol])
                    rooms[curRow][curCol] = dis;
                for (int[] vec : v) {
                    int nextR = curRow + vec[0];
                    int nextC = curCol + vec[1];
                    if (nextR >= 0 && nextR < rooms.length && nextC >= 0 
                        && nextC < rooms[0].length && !visited[nextR][nextC]
                       && rooms[nextR][nextC] != -1 && rooms[nextR][nextC] != 0) {
                        rQueue.offer(nextR);
                        cQueue.offer(nextC);
                        visited[nextR][nextC] = true;
                    }
                }
            }
            dis++;
        }
    }
}