class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        int num = 0;
        while (i < word.length() && j < abbr.length()) {
            if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                num = num * 10 + abbr.charAt(j) - '0';
                if (num > 20 || num == 0)
                    return false;
                j++;
            } else {
                if (num > 0) {
                    i += num;
                    num = 0;
                } else {
                    if (word.charAt(i) != abbr.charAt(j))
                        return false;
                    i++;
                    j++;
                }
            }
        }
        if (num > 0) {
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
}