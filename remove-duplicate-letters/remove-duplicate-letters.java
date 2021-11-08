class Solution {
    public String removeDuplicateLetters(String s) {
        /*
        
        
        cbacdcbc
        a 2
        b 6
        c 7
        d 4
        
        */
        int[] lastPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }
        ArrayDeque<Character> stack = new ArrayDeque();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (visited[c])
                continue;
            while (!stack.isEmpty() && stack.peek() > c + 'a' && i < lastPos[stack.peek() - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(s.charAt(i));
            visited[c] = true;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}