class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 1)
            return List.of("()");
        Set<String> rs = new HashSet();
        for (String s : generateParenthesis(n - 1)) {
            rs.add("("+s+")");
            rs.add("()"+s);
            rs.add(s+"()");
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                     String newString = s.substring(0, i + 1)
                               + "()"
                               + s.substring(i + 1);
                    rs.add(newString);
                } 
            }
        }
        return new ArrayList(rs);     
    }
}