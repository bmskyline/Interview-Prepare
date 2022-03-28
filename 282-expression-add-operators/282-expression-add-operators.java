class Solution {
    public List<String> addOperators(String num, int target) {
        /*
        
        1 + 
        1 - 
        1 * 
        1 /
        12
        */
        List<String> res = new ArrayList();
        generate(res, num, target, 0, 0, 0, new StringBuilder());
        return res;
    }
    
    void generate(List<String> res, String s, int target, int i, long pre, long value, StringBuilder path) {
        if (i == s.length()) {
            if (value == target) res.add(path.toString());
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (j > i && s.charAt(i) == '0') 
                break;
            long num = Long.parseLong(s.substring(i, j + 1));
            int cur = path.length();
            if (i == 0) {
                generate(res, s, target, j + 1, num, num, path.append(num));
                path.delete(cur, path.length());
            } else {
                generate(res, s, target,j + 1, num, value + num, path.append("+").append(num));
                path.delete(cur, path.length());
                generate(res, s, target,j + 1, -num, value - num, path.append("-").append(num));
                path.delete(cur, path.length());
                generate(res,s, target, j + 1, pre * num, value - pre + pre * num, path.append("*").append(num));
                path.delete(cur, path.length());
            }
        }
    }
}