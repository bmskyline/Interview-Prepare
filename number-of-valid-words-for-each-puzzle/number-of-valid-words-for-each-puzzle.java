class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        /*
        abcdefg
        faced contain a and acdef in the word
        
        map a b e o v y z
        map 
        has first letter
        
        10000000000000000000000001
        11000000000100000010000011
        
        */
        
        TrieNode root = new TrieNode();
        for (String s : words) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            StringBuilder str = new StringBuilder();
            str.append(ch[0]);
            for (int i = 1; i < ch.length; i++) {
                if (ch[i] != ch[i - 1]) {
                    str.append(ch[i]);
                }
            }
            insert(root, str.toString());
        }
        List<Integer> res = new ArrayList();
        for (int i = 0; i < puzzles.length; i++) {
            res.add(search(root, puzzles[i], 'a'));
        }
        return res;
    }
    
    void insert(TrieNode root, String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.word = word;
        ws.count++;
    }
    
    int search(TrieNode root, String word, char start) {
        int count = 0;
        TrieNode ws = root;
        if (ws.word != null && ws.word.indexOf(word.charAt(0)) != -1){
            count += ws.count;
        }
        for(char c = start; c <= 'z'; c++) {
            if (ws.children[c-'a'] != null && word.indexOf(c) != -1){
                count += search(ws.children[c-'a'], word, (char)(c+1));
            }
        }
        return count;
    }
}

class TrieNode {
    String word = null;
    TrieNode[] children = new TrieNode[26];
    int count = 0;
    public TrieNode () {}
}
/*
Time complexity : O(a * nlogn)
a : words length
n : max(word[i].length)
Space complexity : O(7! * 26)
*/