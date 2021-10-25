class Solution {
    public int compress(char[] chars) {
        /*
        cur = b
        count = 1
        
        a a b
        */
        int pos = 0, i = 0;
        while(i < chars.length){
            char currentChar = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == currentChar){
                i++;
                count++;
            }
            chars[pos++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[pos++] = c;
        }
        return pos;
    }
}