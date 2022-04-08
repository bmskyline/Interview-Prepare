class Solution {
    public long maxPoints(int[][] p) {
        int lastIdx = p.length - 1;
        int n = p.length;
        int m = p[0].length;
        long max = 0;
        long[] dp = new long[m];
        long[] pre = new long[m];
        for (int i = 0; i < n; i++) {
            long runMax = 0;
            for (int j = 0; j < m; j++) {
                runMax = Math.max(runMax - 1, pre[j]);
                dp[j] = runMax + p[i][j];
            }
            for (int j = m - 1; j >= 0; j--) {
                runMax = Math.max(runMax - 1, pre[j]);
                dp[j] = Math.max(dp[j], runMax + p[i][j]);
            }
            //System.out.println(Arrays.toString(dp));
            pre = dp;
            dp = new long[m];
        }
        for (long x : pre) {
            max = Math.max(max, x);
        }
        return max;
        /*
        1 2 3
        1 2 3
        3 3 3
        */
        
    }
}