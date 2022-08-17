class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> map = new HashSet();
        StringBuilder decode = new StringBuilder();
        for(String w : words) {
            for (int i = 0; i < w.length(); i++) {
                decode.append(table[w.charAt(i) - 'a']);
            }
            if (!map.contains(decode)) {
                map.add(decode.toString());
            }
            decode.setLength(0);
        }
        return map.size();
    }
}