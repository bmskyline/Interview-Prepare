class Solution {
    public String customSortString(String order, String s) {
        /*
        f c b a d t
        1 0 2 4 3 2
        fre : aabbdaddfa
        priority 
        a 4
        b 3
        c 2
        f 1
        d 5
        
        f bb aaaadddddd
        */
        int[] fre = new int[26];
        int[] pos = new int[26];
        for (int i = 0; i < order.length(); i++) {
            pos[order.charAt(i) - 'a'] = i + 1;
        }
        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> pos[a - 'a'] - pos[b - 'a']);
        for (int i = 0; i < s.length(); i++) {
            if (fre[s.charAt(i) - 'a'] == 0)
                q.offer(s.charAt(i));
            fre[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            while (fre[c - 'a'] > 0) {
                res.append(c);
                fre[c - 'a']--;
            }
        }
        return res.toString();
    }
}