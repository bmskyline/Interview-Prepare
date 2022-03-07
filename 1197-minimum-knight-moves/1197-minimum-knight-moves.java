class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] v = new int[][] {{-2, -1}, {-1, -2} ,{1, -2}, {2, -1}, 
                                 {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        Deque<Integer> xQ = new ArrayDeque();
        Deque<Integer> yQ = new ArrayDeque();
        xQ.offer(0);
        yQ.offer(0);
        boolean[][] visited = new boolean[607][607];
        visited[302][302] = true;
        int step = 0;
        while (!xQ.isEmpty()) {
            int size = xQ.size();
            for (int i = 0; i < size; i++) {
                int curX = xQ.poll();
                int curY = yQ.poll();
                if (curX == x && curY == y)
                    return step;
                for (int[] vec : v) {
                    int nextX = curX + vec[0];
                    int nextY = curY + vec[1];
                    if (!visited[nextX + 302][nextY + 302]) {
                        xQ.offer(nextX);
                        yQ.offer(nextY);
                    }
                    visited[nextX + 302][nextY + 302] = true;
                }
            }
            step++;
        }
        return step;
    }
}