class Solution {
    enum Color {G,B};
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList();
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
        }
        return dfs(g, source, destination, new Color[n]);
    }
    
    boolean dfs(List<Integer>[] g, int s, int des, Color[] visited) {
        if (visited[s] != null)
            return visited[s] == Color.B;
        if (g[s].size() == 0) {
            if (s == des)
                return true;
            return false;
        } 
        
        visited[s] = Color.G;
        for (int next : g[s]) {
            if (!dfs(g, next, des, visited))
                return false;
        }
        visited[s] = Color.B;
        return true;
    }
}