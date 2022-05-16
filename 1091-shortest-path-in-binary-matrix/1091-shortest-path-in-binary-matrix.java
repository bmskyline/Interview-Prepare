class Solution {
    private int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        // BFS
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int res = 1;
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) return res;
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1) continue;
                    q.offer(new int[]{x, y});
                    grid[x][y] = 1;
                }
            }
            res ++;
        }
        
        return -1;
    }
}