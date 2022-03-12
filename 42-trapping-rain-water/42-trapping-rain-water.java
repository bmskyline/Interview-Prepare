class Solution {
    public int trap(int[] h) {
        int n = h.length;
        if (n == 1)
            return 0;
        int count = 0;
        int l = 0;
        int r = n - 1;
        int h1 = h[l];
        int h2 = h[r];
        while (l < r) {
            if (h[l] < h[r]) {
                if (h[l] >= h1)
                    h1 = h[l];
                else count += h1 - h[l];
                l++;
            } else {
                if (h[r] >= h2)
                    h2 = h[r];
                else count += h2 - h[r];
                r--;
            }
        }
        return count;
    }
}