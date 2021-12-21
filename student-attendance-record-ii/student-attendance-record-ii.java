class Solution {
    int mod = 1000000007;
    public int checkRecord(int n) {
        int[][][] map = new int[n+1][3][3];
        return dp(0, 1, 0, n, map);
    }
    
    int dp(int ord, int bA, int nL, int n, int[][][] map) {
        if (ord == n) {
            return 1;
        }
        if (map[ord][bA][nL] > 0) {
            return map[ord][bA][nL];
        }
        long res = 0;
        //P
        res += dp(ord + 1, bA, 0, n, map);
        //A
        if (bA == 1) {
            res += dp(ord + 1, 2, 0, n, map);
        }
        if (nL < 2) {
            res += dp(ord + 1, bA, nL + 1, n, map);
        }
        res = res % mod;
        map[ord][bA][nL] = (int)res;
        return map[ord][bA][nL];
    }
}