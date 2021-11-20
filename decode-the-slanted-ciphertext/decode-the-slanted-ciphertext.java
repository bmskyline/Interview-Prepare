class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int cols = encodedText.length() / rows;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < encodedText.length(); j += cols + 1) {
                res.append(encodedText.charAt(j));
            }
        }
        return res.toString().stripTrailing();
    }
    /*
    Time complexity : O(n)
    Space complexity: O(n)
    */
}