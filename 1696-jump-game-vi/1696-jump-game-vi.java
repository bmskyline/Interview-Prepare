class Solution {
    public int maxResult(int[] nums, int k) {
        int[] scores = new int[nums.length];
        Deque<Integer> queue = new ArrayDeque();

        scores[0] = nums[0];
        queue.offer(0);

        for (int i = 1 ; i < nums.length ; i++) {
            if (queue.peek() < i - k) {
                queue.poll();
            }
            scores[i] = scores[queue.peek()] + nums[i];

            while (!queue.isEmpty() && scores[queue.getLast()] <= scores[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        return scores[nums.length - 1];
    }
    
}