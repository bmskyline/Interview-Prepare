class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge: times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        boolean[] visited = new boolean[n + 1];
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        pq.offer(new int[]{0, k});
        int max = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[1];
            if (visited[currNode])
                continue;
            visited[currNode] = true;
            int currDis = curr[0];
            max = currDis;
            n--;
            if (graph.containsKey(currNode)) {
                for (int[] next : graph.get(currNode)) {
                    if (!visited[next[0]] && currDis + next[1] < dis[next[0]]) {
                        pq.offer(new int[]{currDis + next[1], next[0]});
                    }
                }
            }
        }
        return n == 0 ? max : -1;
    }
}