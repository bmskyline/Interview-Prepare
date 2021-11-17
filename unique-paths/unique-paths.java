class Solution {
    public int uniquePaths(int m, int n) {
        Map<String, Integer> map = new HashMap();
        return dp(m, n, map);
    }
    
    public int dp(int m, int n, Map<String, Integer> map) {
        String key = m+","+n;
        if(m <= 0 || n <= 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        if (map.containsKey(key))
            return map.get(key);
        int res = dp(m-1, n, map) + dp(m, n-1, map);
        map.put(key, res);
        return res;
    }
    /*
    Time complexity : O(m*n)
    Space complexity : O(m*n)
    */
}