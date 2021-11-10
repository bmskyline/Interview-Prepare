class Solution {
    public int findLongestChain(int[][] pairs) {
        /*
        12 23 34
        12 45 78
        13 13 13
        12 15 35 67
        */
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }
        return count;
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(logn)
    */
}