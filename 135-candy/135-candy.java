class Solution {
    public int candy(int[] ratings) {
        /*
        1   0   2
        2   1   2
        
        1   2   2
        1   2   1
        
        1   2   1   3   2   4   3
        1   2   1   2   1   2  1
        
        1   2   4   1   3   2   4   3
        1   2   3   1   2   1   2   1
        
        1   2   3   4   5
        1   2   3   4   5
        
        5   4   3   2   1
        5   4   3   2   1
        
        4 2 1 3 5
        1 1 1 2 3
        3 2 1 1 1
        3 2 1 2 3
        */
        int n = ratings.length;
        int total = 0;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        leftToRight[0] = 1;
        rightToLeft[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            } else {
                leftToRight[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            } else {
                rightToLeft[i] = 1;
            }
            total += Math.max(leftToRight[i], rightToLeft[i]);
        }
        total += Math.max(leftToRight[n-1], rightToLeft[n-1]);
        return total;
    }
}