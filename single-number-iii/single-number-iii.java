class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int x : nums) {
            xor ^= x;
        }
        int idx = 0;
        for (int i = 0; i < 32; i++) {
            if((xor & (1<<i)) > 0) {
                idx = i;
                break;
            }
        }
        int first = 0;
        for (int i=0; i < nums.length; i++){
            if((nums[i] & (1<<idx)) > 0){
                first^=nums[i];
            }
        }
        int second = xor ^ first;
        return new int[] {first, second};
    }
    /*
    Time complexity : O(n)
    Scpace complexity : O(1)
    */
}