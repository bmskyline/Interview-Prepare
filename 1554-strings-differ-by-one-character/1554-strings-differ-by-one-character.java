class Solution {
    public boolean differByOne(String[] dict) {
        long[] hash = new long[dict.length];
        long MOD = (long) Math.pow(10, 11) + 7;
        for (int i = 0; i < dict.length; i++) {
            for (int j = 0; j < dict[i].length(); j++) {
                hash[i] = (hash[i] * 26 + dict[i].charAt(j)) % MOD;
            }
        }
        long mult = 1;
        Set<Long> set = new HashSet();
        for (int j = dict[0].length() - 1; j >= 0; --j) {
            set.clear();
            for (int i = 0; i < dict.length; i++) {
                long h = (MOD + hash[i] - (long)mult * (dict[i].charAt(j) - 'a') % MOD) % MOD;
                if (set.contains(h)) {
                    return true;
                }
                set.add(h);
            }
            mult = 26 * mult % MOD;
        }
        return false;
    }
}