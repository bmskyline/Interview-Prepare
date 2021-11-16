class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (!count(mid, m, n, k))
                l = mid + 1;
            else r = mid;
        }
        return l;
    }
    
    boolean count(int v, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(v / i, n);
        }
        if (count >= k)
            return true;
        return false;
    }
    /*
    Time complexity : O(mlog(m*n))
    Space complexity : O(1)
    */
}