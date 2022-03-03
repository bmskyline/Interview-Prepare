class Solution {
    public int maxLength(int[] ribbons, int k) {
        int max = ribbons[0];
        for (int x : ribbons) {
            max = Math.max(max, x);
        }
        int l = 0;
        int r = max;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (valid(ribbons, k, m)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return valid(ribbons, k, l) ? l : l - 1;
    }
    
    boolean valid(int[] r, int k, int m) {
        if (m == 0)
            return true;
        for (int x : r) {
            k -= x/m;
        }
        return k <= 0 ? true : false;
    }
}