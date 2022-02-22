class Solution {
    public int numSimilarGroups(String[] strs) {
        UF uf = new UF(strs.length);
        int count = strs.length;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].equals(strs[j]) || isSimilar(strs[i], strs[j])) {
                    if (uf.union(i, j))
                        count--;
                }
            }
            
        }
        return count;
    }
    
    boolean isSimilar(String s1, String s2) {
        int count = 0;
        for (int i = 0 ; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2)
                    return false;
            }         
        }
        return count == 2;
    }
}

class UF {
    int[] rank;
    int[] parent;
    public UF(int size) {
        rank = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }            
    }
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public boolean union(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        if (pX == pY)
            return false;
        if (rank[pX] > rank[pY]) {
            parent[pY] = pX;
        } else if (rank[pY] > rank[pX]) {
            parent[pX] = pY;
        } else {
            parent[pY] = pX;
            rank[pX]++;
        }
        return true;
    }
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}