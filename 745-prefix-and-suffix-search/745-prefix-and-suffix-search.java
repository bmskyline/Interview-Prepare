class WordFilter {

    Trie trie = new Trie();
    public WordFilter(String[] words) {
        /*
        #apple
        #pple
        #ple
        #le
        #e
        #
        a#pple
        a#ple
        a#le
        a#e
        a#
        ap#pple
        ap#ple
        ap#le
        ap#e
        ap#
        app#le
        app#e
        app#
        appl#e
        appl#
        apple#
        */
        for (int k = 0; k < words.length; k++) {
            for (int j = 0; j <= words[k].length(); j++) {
                trie.insert(words[k].substring(j) + "|" + words[k], k);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return trie.search(suffix + "|" + prefix);
    }
}

class Trie {
    
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word, int k) {
        TrieNode ws = root;
        ws.index = k;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
            ws.index = k;
        }
        ws.index = k;
    }
    
    public int search(String word) {
        TrieNode ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return -1;
            ws = ws.children[c - 'a'];
        }
        return ws.index;
    }
}

class TrieNode {
    public int index = -1;
    public TrieNode[] children = new TrieNode[28];
    public TrieNode() {}
}
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */