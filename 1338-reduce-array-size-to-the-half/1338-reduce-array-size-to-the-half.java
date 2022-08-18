class Solution {
    
    /*
    int[] arr
    3333 555 22 7
    4    3   
    2 3
    
    
    1 100000
    1 -> 1
    10000 -> 1
    
    */
    
    public int minSetSize(int[] arr) {
        
        int res = 0;
        Map<Integer, Integer> freq = new HashMap();
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> freq.get(b) - freq.get(a));
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int x : freq.keySet()) {
            queue.offer(x);
        }
        int total = 0;
        while (total < arr.length / 2) {
            int curFreq = queue.poll();
            total += freq.get(curFreq);
            res++;
        }
        return res;
    }
}