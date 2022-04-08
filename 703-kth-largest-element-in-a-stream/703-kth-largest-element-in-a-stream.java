class KthLargest {

    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue();
        this.k = k;
        for (int x : nums) {
            queue.offer(x);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */