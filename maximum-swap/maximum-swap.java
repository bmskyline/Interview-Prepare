class Solution {
    public int maximumSwap(int num) {
        /*
        2736
        2 0
        7 1
        3 2
        6 3
        
        
        1 6 5 7 5
       
        76515
       
        7 2 5 1 6
        
        5 5 4 2 6 5
        654255
        
        7 6 5 1 5
        9 9 7 3
        0 1 2 3
        3 7 9
        3 2 1
        
        */
        char[] chars = String.valueOf(num).toCharArray();
        int[] lastPos = new int[10];
        for (int i = 0; i < chars.length; i++) {
            lastPos[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 9; j >= 0; j--) {
                if (chars[i] < j + '0' && i < lastPos[j]) {
                    char temp = chars[i];
                    chars[i] = (char)(j + '0');
                    chars[lastPos[j]] = temp;
                    return Integer.parseInt(new String(chars));  
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}