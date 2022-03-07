class Solution {
    public boolean isOneEditDistance(String s, String t) {
        //return false;
        /*
                 0      1       2       3
        remvoe   b      a
        insert   aab   acb
        replace  false
        
        abc
        abcdef
        
        */
        if (Math.abs(s.length() - t.length()) > 1)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (compare(s, t, i, i + 1))
                return true;
            if (compare(s, t, i + 1, i))
                return true;
            if (s.charAt(i) != t.charAt(i)) {
                if (compare(s, t, i + 1, i + 1))
                    return true;
                return false;
            }
        }
        return s.length() + 1== t.length();
    }
    
    boolean compare(String s, String t, int i, int j) {
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j))
                return false;
            i++;
            j++;
        }
        return i == s.length() && t.length() == j;
    }
}