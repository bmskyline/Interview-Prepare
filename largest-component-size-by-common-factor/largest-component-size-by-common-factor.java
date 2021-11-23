class Solution {
    public int largestComponentSize(int[] nums) {
        /*
        union prime factor 
        */
        int n = nums.length;
        DSU dsu = new DSU(n);
        Map<Integer, Set<Integer>> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int d = 2, x = nums[i];
            while (d * d <= x) {
                if (x % d == 0) {
                    while (x % d == 0) x /= d;
                    idx.putIfAbsent(d, new HashSet<>());
                    idx.get(d).add(i);
                }
                d++;
            }
            if (x > 1) {
                idx.putIfAbsent(x, new HashSet<>());
                idx.get(x).add(i);
            }
        }
        int max = 1;
        int[] count = new int[n];
        for (Set<Integer> s : idx.values()) {
            int fir = s.iterator().next();
            for (int id : s) {
                dsu.union(id, fir);
            }
        }
        for (int i = 0; i < dsu.parent.length; i++) {
            dsu.find(i);
        }
        for (int i = 0; i < dsu.parent.length; i++) {
            count[dsu.parent[i]]++;
            max = Math.max(max, count[dsu.parent[i]]);
        }
        return max;
    }
}

/*
Time complexity : O(n)
Space complexity : O(n)
*/

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
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    boolean union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else if (rank[yr] > rank[xr]) {
            parent[xr] = yr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}