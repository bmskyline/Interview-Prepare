class Solution {
    public String reorganizeString(String s) {
        /*
        aaaacvd
        acavada
        a c d v
        1 2 1 4
        vavcvcvd
        aaaccdd
        acacdad
        avavav
        */
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> q = new PriorityQueue((a,b) -> map.get(b) - map.get(a));
        for (Character c : map.keySet()) {
            q.offer(c);
        }
        if (map.get(q.peek()) > (s.length() + 1) /2)
            return "";
        char[] res = new char[s.length()];
        int idx = 0;
        while (!q.isEmpty()) {
            Character c = q.poll();
            for (int i = 0; i < map.get(c); i++) {
                res[idx] = c;
                idx += 2;
                if (idx >= s.length())
                    idx = 1;
            }
        }
        return String.valueOf(res);
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}