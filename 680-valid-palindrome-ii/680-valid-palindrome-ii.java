class Solution {
    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, false);
    }
    
    boolean valid(String s, int l, int r, boolean deleted) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (deleted) {
                    return false;
                } else return valid(s, l + 1, r, true) || valid(s, l, r - 1, true);
            }
            l++;
            r--;
        }
        return true;
    }
}