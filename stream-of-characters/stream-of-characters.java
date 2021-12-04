class StreamChecker {

    Trie root = new Trie();
    StringBuilder str = new StringBuilder();
    public StreamChecker(String[] words) {
        for (String s : words) {
            insert(s);
        }
    }
    
    public boolean query(char letter) {
        str.append(letter);
        return search(str.toString());
    }
    
    public void insert(String word) {
        Trie ws = root;
        for(int i = word.length() - 1; i >=0 ; i--){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new Trie();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    public boolean search(String word) {
        Trie ws = root; 
        for(int i = word.length() - 1; i >=0 ; i--){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null)
                return false;
            ws = ws.children[c - 'a'];
            if (ws.isWord)
                return true;
        }
        return false;
    }
}
/*
Time complexity : O(nm)
Space complexity : O(m)
n : words.length
m : word.length()
*/

class Trie {
    Trie[] children;
    boolean isWord;
    public Trie() {
         children = new Trie[26];
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */