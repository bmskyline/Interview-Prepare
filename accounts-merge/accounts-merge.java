class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        DSU dsu = new DSU(accounts.size());
        for (int i = 0; i < accounts.size() - 1; i++) {
            Set<String> emails = new HashSet();
            for (int k = 1; k < accounts.get(i).size(); k++) {
                emails.add(accounts.get(i).get(k));
            }
            for (int j = i + 1; j < accounts.size(); j++) {
                if (accounts.get(i).get(0).equals(accounts.get(j).get(0))) {
                    for (int k = 1; k < accounts.get(j).size(); k++) {
                        if (emails.contains(accounts.get(j).get(k))) {
                            dsu.union(i, j);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < accounts.size(); i++) {
            dsu.find(i);
        }
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            Set<String> ret = map.getOrDefault(dsu.parent[i], new HashSet());
            ret.addAll(accounts.get(i));
            map.put(dsu.parent[i], ret);
        }
        List<List<String>> res = new ArrayList();
        for (var entry : map.entrySet()) {
            List<String> a = new ArrayList(entry.getValue());
            a.remove(accounts.get(entry.getKey()).get(0));
            Collections.sort(a);
            a.add(0, accounts.get(entry.getKey()).get(0));
            res.add(a);
        }
        return res;
    }
    /*
    Time complexity : O(n^2)
    Space complexity : O(n)
    */
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
        } else if(rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}