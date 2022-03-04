class Solution {
    public String addBoldTag(String s, String[] words) {
        /*
        111000111
        abcxyz123
        abc
        */
        boolean[] isBold = new boolean[s.length()];
        for (String word : words) {
            findBold(word, s, isBold);
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        boolean open = false;
        while (i < s.length()) {
            if (isBold[i]) {
                if (!open) {
                    res.append("<b>");
                    open = true;
                }
            } else {
                if (open) {
                    res.append("</b>");
                    open = false;
                }
            }
            res.append(s.charAt(i));
            i++;
        }
        if (open)
            res.append("</b>");
        return res.toString();
    }
    
    void findBold(String w, String s, boolean[] isBold) {
        for (int i = 0; i < s.length() - w.length() + 1; i++) {
            for (int j = 0; j < w.length(); j++) {
                if (s.charAt(i + j) != w.charAt(j))
                    break;
                int k = j;
                if (k == w.length() - 1) {
                    while (k >= 0) {
                        isBold[i+k] = true;
                        k--;
                    }
                }
            }
            
        }
    }
}