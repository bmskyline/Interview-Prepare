class Solution {
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & 1<<i) > 0)
                count++;
        }
        return count;
    }
    /*
    Time complexity : O(1)
    Space complexity : O(1)
    */
}