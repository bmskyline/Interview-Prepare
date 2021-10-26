class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] preSum = new int[n+1][26];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i].clone();
            preSum[i + 1][s2.charAt(i) - 'a']++;
        }
        int[] sum = new int[26];
        for (int i = 0; i < m; i++) {
            sum[s1.charAt(i) - 'a']++;
        }
        
        for (int i = m; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                if (preSum[i][j] - preSum[i-m][j] != sum[j]) {
                    break;
                }
                if (j == 25)
                    return true;
            }
        }
        return false;
    }
    
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}