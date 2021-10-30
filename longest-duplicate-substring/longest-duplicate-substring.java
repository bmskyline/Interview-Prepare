class Solution {
    public String longestDupSubstring(String s) {
        int l = 1;
        int r = s.length() - 1;
        String ret = "";
        while (l <= r) {
            int m = l + (r-l) / 2;
            String res = check(s, m);
            if (res == null) {
                r = m - 1;
            } else {
                l = m + 1;
                ret = res;
            }
        }
        return ret;
    }
    
    String check(String s, int len) {
        String pattern = search(s, len);
        if (pattern != null)
            return pattern;
        return null;
    }
    
     private String search(String S, int length) {        
        long hash = 0;
        long prime = 29;
        long firstEntryPower = 1;
        for (int i = 0; i < length; i++) {
            firstEntryPower *= prime;
            hash = hash * prime + (S.charAt(i) - 'a');
        }
        
        Map<Long, Integer> map = new HashMap<>();
        map.put(hash, 0);
        
        for (int i = length; i < S.length(); i++) {
            hash = hash * prime + (S.charAt(i) - 'a');
            hash -= firstEntryPower * (S.charAt(i - length) - 'a');
            
            if (map.containsKey(hash)) {
                int index = map.get(hash);
                return S.substring(index, index + length);
            }
            
            map.put(hash, i - length + 1);
        }
        
        return null;
    }
    
    /*
    Time complexity : O(nlogn)
    Space complexity : O(n)
    */
}