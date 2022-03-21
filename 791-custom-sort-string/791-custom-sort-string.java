class Solution {
    public String customSortString(String order, String s) {
        /*
        f c b a d t
        fre : aabbdaddfa
        priority 
        a 4
        b 3
        c 2
        f 1
        d 5
        
        f bb aaaadddddd
        */
        int[] pos = new int[26];
        for (int i = 0; i < order.length(); i++) {
            pos[order.charAt(i) - 'a'] = i + 1;
        }
        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> pos[a - 'a'] - pos[b - 'a']);
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            res.append(q.poll());
        }
        return res.toString();
    }
}