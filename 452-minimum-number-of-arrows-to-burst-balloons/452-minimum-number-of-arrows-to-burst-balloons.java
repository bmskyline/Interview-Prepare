class Solution {
    public int findMinArrowShots(int[][] points) {
        /*
        1 4
        1 6 
         2  8
           7 12
            10 16
            
         1 2
           2 3
             3 4
               4 5
        
        
        */
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int pos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (pos < points[i][0]) {
                pos = points[i][1];
                count++;
            }
        }
        return count;
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(logn)
    */
}