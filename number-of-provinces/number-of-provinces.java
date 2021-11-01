class Solution {
   
    public int findCircleNum(int[][] M) {
        DSU dsu = new DSU(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (dsu.parent[i] == i)
                count++;
        }
        return count;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}

class DSU {
    int[] parent;
    int[] rank;
    
    public DSU(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }
    
    int find(int x) {
        if (x != parent[x])
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
    
}


   