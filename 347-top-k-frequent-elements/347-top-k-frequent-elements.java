class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int val : nums) {
            if(map.containsKey(val)) {
                int c = map.get(val);
                map.put(val, c+1);
            } else {
                map.put(val, 1);
            }
        }
        int[] top = new int[k];
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> map.get(n1) - map.get(n2));

        for (int n: map.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.poll();    
        }

        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}