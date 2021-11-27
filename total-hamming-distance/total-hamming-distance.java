class Solution {
    public int totalHammingDistance(int[] nums) {
        /*
        0100
        1110
        0010
        2220
        
        0100
        1110
        0100
        2020
        
        0 0 0 1 1 0
        1 2
        3 0
        */
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int x : nums) {
                if ((x & (1<<i)) > 0) {
                    count1++;
                } else {
                    count0++;
                }
            }
            count += count0 * count1;
        }
        return count;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}