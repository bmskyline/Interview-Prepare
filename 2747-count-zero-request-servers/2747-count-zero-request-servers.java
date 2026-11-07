class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        Integer[] ids = new Integer[queries.length];
        for (int i = 0; i < ids.length; i++) ids[i] = i;
        Arrays.sort(ids, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] cnt = new int[n + 1], ans = new int[ids.length];
        int left = 0, right = 0, active = 0;

        for (int i : ids) {
            int q = queries[i];

            while (right < logs.length && logs[right][1] <= q) {
                int id = logs[right][0];
                
                if (cnt[id] == 0) {
                    active++;
                }
                
                cnt[id]++;
                right++;
            }
            while (left < right && logs[left][1] < q - x) {
                int id = logs[left][0];
                
                cnt[id]--;
                if (cnt[id] == 0) {
                    active--;
                }

                left++;
            }

            ans[i] = n - active;
        }

        return ans;
    }
}