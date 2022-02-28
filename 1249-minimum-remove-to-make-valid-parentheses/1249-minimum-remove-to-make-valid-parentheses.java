class Solution {
    public String minRemoveToMakeValid(String s) {
        int balance = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else if (s.charAt(i) == ')') {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            res.append(s.charAt(i));
        }
        
        for (int i = res.length() - 1; i >= 0; i--) {
            if (balance > 0 && res.charAt(i) == '(') {
                res.deleteCharAt(i);
                balance--;
                if (balance == 0)
                    break;
            }
        }
        return res.toString();
    }
}