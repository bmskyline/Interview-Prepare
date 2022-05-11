class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        /*
        1 2 3 4
        3 4 5 6
        
        
        1 2 2 3 3 3 4 4 5 9 10 11
        
        2 3 4 5 9 10 11
        1 2 2 1 1 1  1
        
        
        1 2 3
        2 3 4
        3 4 5
        9 10 11
        */
        
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        while (!map.isEmpty()) {
            int firstKey = map.firstKey();
            for (int i = 0; i < k; i++) {
                int key = firstKey + i;
                if (map.containsKey(key)) {
                    if (map.get(key) == 1)
                        map.remove(key);
                    else map.put(key, map.get(key) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}