class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] fre = new int[26];
        for (int i = 0 ; i < s.length(); i++) {
            fre[s.charAt(i) - 'a']++;
        }
        boolean hadOdd = false;
        for (int i = 0 ; i < 26; i++) {
            if (fre[i] % 2 == 1) {
                if (hadOdd)
                    return false;
                hadOdd = true;
            }
        }
        return true;
    }
}