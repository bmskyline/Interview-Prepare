class MovingAverage {

    Queue<Integer> queue;
    int sum;
    int size;
    public MovingAverage(int size) {
        queue = new LinkedList();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        return (double) sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */