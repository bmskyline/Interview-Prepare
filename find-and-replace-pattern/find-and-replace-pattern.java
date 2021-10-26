class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        
        List<String> res = new ArrayList();
        int n = pattern.length();
        for (String s : words) {
            HashMap<Character, Character> map = new HashMap();
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(pattern.charAt(i))) {
                    if (map.containsValue(s.charAt(i)))
                            break;
                    else map.put(pattern.charAt(i), s.charAt(i));
                } else {
                    if (map.get(pattern.charAt(i)) != s.charAt(i)) {
                        break;
                    }
                }
                if (i == n - 1)
                    res.add(s);
            }
            
        }
        return res;
        /*
        Time complexity : O(n)
        Space complexity : O(n)
        */
    }
}