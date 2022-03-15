class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList();
        Trie trie = new Trie();
        for (String str : wordDict) {
            trie.insert(str);
        }
        helper(res, s, trie, 0, new StringBuilder());
        return res;
    }
    
    void helper(List<String> res, String s, Trie trie, int pos, StringBuilder sen) {
        if (pos == s.length()) {
            res.add(sen.toString().trim());
            return;
        }
        
        StringBuilder word = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            word.append(s.charAt(i));
            if (trie.search(word.toString())) {
                int len = sen.length();
                sen.append(" ").append(word);
                helper(res, s, trie, i + 1, sen);
                sen.setLength(len);
            }
        }
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    
    void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }
}
class TrieNode {
    TrieNode[] children;
    boolean isWord; 
    TrieNode() {
        children = new TrieNode[26];
    }
}