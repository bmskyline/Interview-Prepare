class Solution {
    public int singleNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        int mask = 0;
        for (int x : nums) {
            xor2 ^= xor1 & x;
            xor1 ^= x;
            mask = ~(xor1 & xor2);
            xor1 &= mask;
            xor2 &= mask;
        }
        return xor1;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}