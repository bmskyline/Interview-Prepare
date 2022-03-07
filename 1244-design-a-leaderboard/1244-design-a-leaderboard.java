class Leaderboard {

    Map<Integer, Integer> score;
    PriorityQueue<Integer> top;
    public Leaderboard() {
        score = new HashMap();
        top = new PriorityQueue<>((a, b) -> score.get(b) - score.get(a));
    }
    
    public void addScore(int playerId, int s) {
        if (score.containsKey(playerId)) {
            top.remove(playerId);
        }
        score.put(playerId, s + score.getOrDefault(playerId, 0));
        top.offer(playerId);
    }
    
    public int top(int K) {
        int sum = 0;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < K; i++) {
            if (!top.isEmpty()) {
                int player = top.poll();
                sum += score.get(player);
                list.add(player);
            }
        }
        for (int x : list) {
            top.offer(x);
        }
        return sum;
    }
    
    public void reset(int playerId) {
        score.remove(playerId);
        top.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */