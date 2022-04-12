class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int max = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            int l = 0;
            int r = max - 1;
            while (l <= r) {
                //3 7 8 6
                int m = l + (r - l) / 2;
                if (envelopes[i][1] > dp[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            dp[l] = envelopes[i][1];
            if (l == max)
                max++;
        }
        return max;
    }
}