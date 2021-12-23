class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<Integer>[] g = new ArrayList[n];
        int[] degree = new int[n];
        for (int i = 0; i < pre.length; i++) {
            if (g[pre[i][1]] == null)
                g[pre[i][1]] = new ArrayList();
            g[pre[i][1]].add(pre[i][0]);
            degree[pre[i][0]]++;
        }
        Queue<Integer> q = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            if (g[i] == null)
                g[i] = new ArrayList();
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
        int[] res = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            res[idx++] = current;
            for (int adjacent : g[current]) {
                degree[adjacent] -= 1;
                if (degree[adjacent] == 0) {
                    q.add(adjacent);
                }
            }
        }
        if (idx != n) {
            return new int[0];
        }
        return res;
    }
    /*
    Time complexity : O(v * e)
    Space complexity : O(v)
    */
}