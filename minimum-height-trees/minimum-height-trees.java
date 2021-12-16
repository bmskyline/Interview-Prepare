class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /*
        0 1
        1 3
        2 1
        3 1   
        [[3,0],[3,1],[3,2],[3,4],[5,4],[2,6],[2,7][7,8]]
        0 1 2 3 4 5 6 7 8 
        1 1 3 4 2 1 1 2 1
        
        0 3
        1 3
        2 3 6 7
        3 0 1 2 4
        4 3 5
        5 4
        6 2
        7 2 8
        8 7
        
        0 3 1 -> 2
        1 3 0-> 2
        
        */
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }
        List<Integer>[] g = new ArrayList[n];
        int[] degree = new int[n];
        for (int[] edge : edges) {
            if (g[edge[0]] == null) {
                g[edge[0]] = new ArrayList();
            }
            if (g[edge[1]] == null) {
                g[edge[1]] = new ArrayList();
            }
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
            degree[edge[0]]++;
    	    degree[edge[1]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        
        for (int i = 0; i< n; i++) {
            if (degree[i] == 1)
                queue.offer(i);
        }
        List<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            res.clear();
            int count = queue.size();

            for (int i = 0; i < count; i++){
                int curr = queue.poll();
                res.add(curr);
                degree[curr]--;
                for (int k = 0; k < g[curr].size(); k++) {
                    int next = g[curr].get(k);
                    if (degree[next] == 0)
                        continue;
                    if (degree[next] == 2) {
                        queue.offer(next);
                    }
                    degree[next]--;
                }
            }      	
        }
        return res;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}