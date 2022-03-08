class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        /*
        a z 
        az y
        ba b < z  a-a = 0 z-z = 0+1 y-z= 1 a- b = 1
        */
        List<List<String>> res = new ArrayList();
        UF uf = new UF(strings.length);
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (isSameGroup(strings[i], strings[j]))
                    uf.union(i, j);
            }
        }
        List<String>[] list = new ArrayList[strings.length];
        for (int i = 0; i < strings.length; i++) {
            list[i] = new ArrayList();
        }
        for (int i = 0; i < strings.length; i++) {
            int idx = uf.find(i);
            list[idx].add(strings[i]);
        }
        for (int i = 0; i < strings.length; i++) {
            if (list[i].size() > 0)
                res.add(list[i]);
        }
        return res;
    }
    
    boolean isSameGroup(String a, String b) {
        if (a.length() != b.length())
            return false;
        int dis = distant(a.charAt(0), b.charAt(0));
        for (int i = 1; i < a.length(); i++) {
            if (distant(a.charAt(i), b.charAt(i)) != dis)
                return false;
        }
        return true;
    }
    
    int distant(char a, char b) {
        if (a <= b) {
            return b - a;
        } else {
            return ('z' - a) + (b - 'a') + 1;
        }
    }
}

class UF{
    int[] rank;
    int[] parent;
    public UF(int size) {
        rank = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    
    int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
    
    boolean union(int x, int y) {
        int rX = find(x);
        int rY = find(y);
        if (rX == rY)
            return false;
        if (rank[rX] > rank[rY]) {
            parent[rY] = rX;
        } else if (rank[rX] < rank[rY]) {
             parent[rX] = rY;
        } else {
            parent[rY] = rX;
            rank[rX]++;
        }
        return true;
    }
    
    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}