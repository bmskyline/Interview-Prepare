class Solution {
    public boolean differByOne(String[] dict) {
        Long[] hashTable = new Long[dict.length];
        for (int i = 0; i < dict.length; i++) {
            String w = dict[i];
            long hash = 0;
            for (int j = 0; j < w.length(); j++) {
                hash = hash * 26 + (w.charAt(j) - 'a');

            }
            hashTable[i] = hash;
        }
        Set<Long> set = new HashSet<>();
        long base = 1;
        for (int i = dict[0].length() - 1; i >= 0; i--) {
            set.clear();
            for (int j = 0; j < dict.length; j++) {
                long cur = hashTable[j] - (dict[j].charAt(i) - 'a') * base;
                if (set.contains(cur)) {
                    return true;
                }
                set.add(cur);
            }
            base *= 26;
        }
        return false;
    }
}