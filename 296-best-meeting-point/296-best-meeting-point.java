class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList();
        List<Integer> cols = new ArrayList();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    rows.add(r);
                    cols.add(c);
                } 
            }
        }
        Collections.sort(rows);
        Collections.sort(cols);
        return cal(rows, rows.size() /2) + cal(cols, cols.size() / 2);
    }
    
    int cal(List<Integer> list, int med) {
        int count = 0;
        for (int x : list) {
            count += Math.abs(x - list.get(med));
        }
        return count;
    }
}