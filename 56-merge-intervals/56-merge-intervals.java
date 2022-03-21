class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][0] <= intervals[i+1][1] 
                && intervals[i+1][0] <= intervals[i][1]) {
                intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        res.add(intervals[intervals.length - 1]);
        return res.toArray(new int[res.size()][]);
    }
}