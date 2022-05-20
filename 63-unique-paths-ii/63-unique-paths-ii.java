class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int[][] res = new int[obs.length][obs[0].length];
        //Arrays.stream(res).forEach(a -> Arrays.fill(a, -1));
        return dp(obs, res, obs.length-1, obs[0].length-1);
    }
    
    public int dp(int[][] obs, int[][] res, int m, int n) {
        if(m < 0 || n < 0)
            return 0;
        if (obs[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if (res[m][n] != 0)
            return res[m][n];
        res[m][n] = dp(obs, res, m-1, n) + dp(obs, res, m, n-1);
        return res[m][n];
    }
}