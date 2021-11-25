class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        /*
        4 5
        1 2
        
        */
        Map<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : map.keySet()) {
            q.offer(x);
        }
        while (k > 0) {
            int num = q.poll();
            if (k >= map.get(num)) {
                k -= map.get(num);
                map.remove(num);
            } else {
                map.put(num, map.get(num) - k);
                k = 0;
            }
        }
        return map.size();
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(n)
    */
}