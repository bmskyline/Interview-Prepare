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
        generate(res, num, target, 0, 0, 0, "");
        return res;
    }
    
    void generate(List<String> res, String s, int target, int i, long pre, long value, String path) {
        if (i == s.length()) {
            if (value == target) res.add(path);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (j > i && s.charAt(i) == '0') 
                break;
            long num = Long.parseLong(s.substring(i, j + 1));
            if (i == 0) {
                generate(res, s, target, j + 1, num, num, path + num);
            } else {
                generate(res, s, target,j + 1, num, value + num, path + "+" + num);
                generate(res, s, target,j + 1, -num, value - num, path + "-" + num);
                generate(res,s, target, j + 1, pre * num, value - pre + pre * num, path + "*" + num);
            }
        }
    }
}