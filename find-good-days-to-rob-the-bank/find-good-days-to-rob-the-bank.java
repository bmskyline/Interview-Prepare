class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] dec = new int[security.length];
        int[] inc = new int[security.length];
        for (int i = 1; i < security.length; i++) {
            if (security[i] == security[i-1]) {
                inc[i] = inc[i-1] + 1;
                dec[i] = dec[i-1] + 1;
            } else if (security[i] > security[i-1]) {
                inc[i] = inc[i-1] + 1;
                dec[i] = 0;
            } else {
                inc[i] = 0;
                dec[i] = dec[i-1] + 1;
            }
        }
        List<Integer> res = new ArrayList();
        for (int i = time; i < security.length - time; i++) {
            if (dec[i] - time == dec[i - time] 
                && inc[i] + time == inc[i + time])
                res.add(i);
        }
        return res;
    }
}