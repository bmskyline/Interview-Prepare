class Solution {
    public char findKthBit(int n, int k) {
        String[] table = new String[n];
        table[0] = "0";
        for (int i = 1; i < n; i++) {
            table[i] = table[i - 1]+"1" + invert(table[i - 1]).reverse();
        }
        return table[n - 1].charAt(k - 1);
    }
    
    StringBuilder invert(String s) {
        return new StringBuilder(s.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1"));
    }
}