class Solution {
    List<String> res = new ArrayList();
    public List<String> letterCombinations(String digits) {
        /*
        a b c
        a
        */
        List<List<Character>> map = new ArrayList();
        map.add(Arrays.asList('a', 'b', 'c'));
        map.add(Arrays.asList('d', 'e', 'f'));
        map.add(Arrays.asList('g', 'h', 'i'));
        map.add(Arrays.asList('j', 'k', 'l'));
        map.add(Arrays.asList('m', 'n', 'o'));
        map.add(Arrays.asList('p', 'q', 'r', 's'));
        map.add(Arrays.asList('t', 'u', 'v'));
        map.add(Arrays.asList('w', 'x', 'y', 'z'));
        if (digits.length() == 0)
            return res;
        backtrack(digits, map, 0, new ArrayList());
        return res;
    }
    
    void backtrack(String s, List<List<Character>> map, int ord, List<Character> list) {
        if (list.size() == s.length()) {
            StringBuilder str = new StringBuilder();
            for (Character c : list) {
                str.append(c);
            }
            res.add(str.toString());
            return;
        }
        for (Character ch : map.get(s.charAt(ord) - '0' - 2)) {
            list.add(ch);
            backtrack(s, map, ord + 1, list);
            list.remove(list.size() - 1);
        }
    }
}