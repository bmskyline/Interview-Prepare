class Solution {
    public int getMoneyAmount(int n) {
        Map<Pair<Integer, Integer>, Integer> map = new HashMap();
        return cal(1, n, map);
    }
    
    int cal(int from, int to, Map<Pair<Integer, Integer>, Integer> map) {
        if (from >= to)
            return 0;
        Pair key = new Pair(from, to);
        if (map.containsKey(key))
            return map.get(key);
        int min = Integer.MAX_VALUE;
        for (int i = from + (to - from) / 2; i <= to; i++) {
            min = Math.min(min, Math.max(cal(from, i - 1, map), cal(i + 1, to, map)) + i);
        }
        map.put(key, min);
        return map.get(key);
    }
}