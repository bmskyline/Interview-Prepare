class Solution {
    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                dfs(stones, i, visited);
                count++;
            }
        }
        return stones.length - count;
    }
    
    void dfs(int[][] stones, int i, boolean[] visited) {
        if (visited[i])
            return;
        visited[i] = true;
        for (int j = 0; j < stones.length; j++) {
            if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                dfs(stones, j, visited);
            }
        }
    }
    
    /*
    Time complexity : O(n^2)
    Space complexity : O(n^2)
    */
}