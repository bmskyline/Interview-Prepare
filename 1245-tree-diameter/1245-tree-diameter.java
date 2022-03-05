class Solution {
    int max = 0;
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        int[] indegree = new int [n];
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0)
                root = i;
        }
        dfs(root, g);
        return max;
    }
    
    int dfs(int root, List<Integer>[] g) {
        if (g[root].size() == 0) {
            return 1;
        }
        int first = 0;
        int second = 0;
        for (int x : g[root]) {
            int d = dfs(x, g);
            if (d >= first) {
                second = first;
                first = d;
            } else if (d > second) {
                second = d;
            }
        }
        max = Math.max(max, first + second);
        return first + 1;
    }
}