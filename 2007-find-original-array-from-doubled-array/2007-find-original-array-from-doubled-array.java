class Solution {
    public int[] findOriginalArray(int[] changed) {
        /*
        1    2        
        122 444 88
        84 84 42 21
        
        - sort array
        - from 
        */
        int n = changed.length;
        int[] res = new int[n/2];
        if (n % 2 == 1)
            return new int[0];; 
        Map<Integer, Integer> map = new TreeMap();
        for (int x : changed) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int i = 0;
        for (int key : map.keySet()) {
            int doub = key + key;
            if (map.get(key) > map.getOrDefault(doub, 0))
                return new int[0];
            for (int j = 0; j < map.get(key); ++j) {
                res[i++] = key;
                map.put(doub, map.get(doub) - 1);
            }
        }
        return res;
    }
}