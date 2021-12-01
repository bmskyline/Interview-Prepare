class Solution {
    
    public int rob(int[] nums) {
        int rob = 0;
        int noRob = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = rob;
            rob = noRob + nums[i];
            noRob = Math.max(noRob, temp);
        }
        return Math.max(rob, noRob);
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}