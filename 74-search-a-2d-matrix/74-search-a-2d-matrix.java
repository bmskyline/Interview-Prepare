class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0;
        int d = matrix.length - 1;
        while (t <= d) {
            int m = t + (d - t) / 2;
            if (matrix[m][0] == target) {
                return true;
            } else if (matrix[m][0] > target) {
                d = m - 1;
            } else {
                t = m + 1;
            }
        }
        if (t != 0)
            t--;
        if(Arrays.binarySearch(matrix[t], target) >= 0)
            return true;
        return false;
    }
}