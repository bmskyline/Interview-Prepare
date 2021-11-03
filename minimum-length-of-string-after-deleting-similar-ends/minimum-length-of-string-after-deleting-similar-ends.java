class Solution {
    public int minimumLength(String s) {
        /*
        aaaaaa
        res = 6
        l = 5
        r= 5
        */
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            int res = r - l +1;
            while (l < r && s.charAt(l) == s.charAt(l+1)) {
                l++;
            }
            if (l == r)
                return 0;
            while (l < r && s.charAt(r) == s.charAt(r-1)) {
                r--;
            }
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return res;
            }
        }
        return r - l + 1;
        /*
        Time complexity : O(n)
        Space complexity : O(1)
        */
    }
}