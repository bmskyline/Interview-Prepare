class Solution {
    public boolean isValidPalindrome(String s, int k) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return isValid(s, 0, s.length() - 1, dp) <= k;
    }
    
    int isValid(String s, int l, int r, Integer[][] dp) {
        if (l > r)
            return 0;
        if (dp[l][r] != null)
            return dp[l][r];
        if (s.charAt(l) == s.charAt(r)) {
            return dp[l][r] = isValid(s, l + 1, r - 1, dp);
        } else {
            dp[l][r] = 1 + Math.min(isValid(s, l + 1, r, dp), isValid(s, l, r-1, dp));
            return dp[l][r];
        }
    }
}