class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        DSU dsu = new DSU(1001);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1]))
                return edge;
        }
        return new int[2];
    }
}

class DSU {
    int[] parent;
    int[] rank;
    
    public DSU(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    
    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    boolean union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}