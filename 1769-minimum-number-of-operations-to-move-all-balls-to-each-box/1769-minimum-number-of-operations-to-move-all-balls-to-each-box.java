class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        int ball = 0;
        int op = 0;
        for (int i = 0; i < boxes.length(); i++) {
            res[i] += op;
            ball += boxes.charAt(i) == '1' ? 1 : 0;
            op += ball; 
        }
        ball = 0;
        op = 0;
        for (int i = boxes.length() - 1; i >= 0; i--) {
            res[i] += op;
            ball += boxes.charAt(i) == '1' ? 1 : 0;
            op += ball; 
        }
        return res;
    }
}