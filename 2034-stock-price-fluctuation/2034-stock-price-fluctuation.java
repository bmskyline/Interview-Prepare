class StockPrice {

    /*
    1 10
    2 5
    cur = 5
    max = 10
    
    */
    class Stock {
        int time;
        int price;
        public Stock(int a, int b) {
            time = a;
            price = b;
        }
    }
    PriorityQueue<Stock> min;
    PriorityQueue<Stock> max;
    Map<Integer, Integer> map;
    int latest;
    public StockPrice() {
        map = new HashMap();
        latest = 0;
        min = new PriorityQueue<>((a, b) -> a.price - b.price);
        max = new PriorityQueue<>((a, b) -> b.price - a.price);
    }
    
    public void update(int timestamp, int price) {
        map.put(timestamp, price);
        Stock stock = new Stock(timestamp, price);
        min.offer(stock);
        max.offer(stock);
        latest = Math.max(latest, timestamp);
    }
    
    public int current() {
        return map.get(latest);
    }
    
    public int maximum() {
        while (true) {
            Stock s = max.peek();
            if (s.price != map.get(s.time)) {
                max.poll();
            } else break;
        }
        return map.get(max.peek().time);
    }
    
    public int minimum() {
        while (true) {
            Stock s = min.peek();
            if (s.price != map.get(s.time)) {
                min.poll();
            } else break;
        }
        return map.get(min.peek().time);
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */