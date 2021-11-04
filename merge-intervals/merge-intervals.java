class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> list = new ArrayList();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][1] > end) {
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(n)
    */
}