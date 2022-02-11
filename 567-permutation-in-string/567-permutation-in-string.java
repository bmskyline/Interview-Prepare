class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[] sum = new int[26];
        for (int i = 0; i < m; i++) {
            sum[s1.charAt(i) - 'a']++;
        }
        int[] s2Sum = new int[26];
        for (int i = 0; i < n; i++) {
            if (i < m) {
                s2Sum[s2.charAt(i) - 'a']++;
            } else {
                if (Arrays.equals(s2Sum, sum))
                    return true;
                s2Sum[s2.charAt(i - m) - 'a']--;
                s2Sum[s2.charAt(i) - 'a']++;
            }
        }
        return Arrays.equals(s2Sum, sum);
    }
    
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}