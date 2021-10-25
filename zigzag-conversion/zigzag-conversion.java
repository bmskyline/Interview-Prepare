class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) 
            return s;

        StringBuilder res = new StringBuilder();
        int start = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += start) {
                res.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + start - i < s.length())
                    res.append(s.charAt(j + start - i));
            }
        }
        return res.toString();
    }
    
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}