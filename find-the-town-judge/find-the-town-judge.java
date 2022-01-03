class Solution {
    public int findJudge(int n, int[][] trust) {
        // 1 2 3
        // 1 2
        int[] table = new int[n+1];
        for (int i = 0; i < trust.length; i++) {
            table[trust[i][0]]--;
            table[trust[i][1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (table[i] == n - 1)
                return i;
        }
        return -1;
    }
}