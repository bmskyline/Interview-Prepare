class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int r = 0;
        int l = 0;
        List<Integer> res = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            r = Math.max(r, last[s.charAt(i) - 'a']);
            if (i == r) {
                res.add(r - l + 1);
                l = i + 1;
            }
        }
        return res;
    }
}