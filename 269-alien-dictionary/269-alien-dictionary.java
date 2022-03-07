class Solution {
    public String alienOrder(String[] words) {
        Map<Integer, Set<Integer>> g = new HashMap();
        int[] indegree = new int[26];
        Set<Character>chs = new HashSet<Character>();
        for (String w : words) {
            for (int j = 0; j < w.length(); j++) {
                chs.add(w.charAt(j));
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].startsWith(words[j]) && words[i].length() > words[j].length())
                    return "";
                addEdge(words[i], words[j] , g);
            }
        }
        Arrays.fill(indegree, -1);
        for (Character c : chs) {
            indegree[c - 'a'] = 0;
        }
        Queue<Integer> zeroDegree = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : g.entrySet()) {
            Integer c = entry.getKey();
            for (int x : entry.getValue()) {
                indegree[x]++;
            }
        }
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != -1) {
                if (indegree[i] == 0){
                    zeroDegree.add(i);
                }
                count++;
            }
            
        } 
        int index = 0;
        char[] result = new char[count];
        while (!zeroDegree.isEmpty()) {
            int course = zeroDegree.poll();
            result[index] = (char)(course+'a');
            index++;
            if (g.containsKey(course)) {
                for (Integer pre : g.get(course)) {
                    indegree[pre]--;
                    if (indegree[pre] == 0) {
                        zeroDegree.add(pre);
                    }
                }
            }
        }
        if (index < count)
            return "";
        return new String(result);
    }
    
    void addEdge(String s, String t, Map<Integer, Set<Integer>> g) {
        if (s.equals(t)) {
            Set<Integer> set = g.getOrDefault(s.charAt(0) - 'a', new HashSet());
            //set.add(t.charAt(0) - 'a');
            g.put(s.charAt(0) - 'a', set);
        }
        int i = 0;
        while (i < Math.min(s.length(), t.length())) {
            if (s.charAt(i) != t.charAt(i)) {
                Set<Integer> set = g.getOrDefault(s.charAt(i) - 'a', new HashSet());
                set.add(t.charAt(i) - 'a');
                g.put(s.charAt(i) - 'a', set);
                break;
            }
            i++;
        }
    }
}