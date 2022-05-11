class Solution {
    public int countVowelStrings(int n) {
        int[] res = new int[5];
        Arrays.fill(res, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 5; j++) {
                res[j] += res[j - 1];
            } 
        }
        int ret = 0;
        for (int j = 0; j < 5; j++) {
            ret += res[j];
        }
        return ret;
    }
}