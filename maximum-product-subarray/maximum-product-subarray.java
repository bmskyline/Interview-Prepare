class Solution {
    public int maxProduct(int[] nums) {
        /*
        if 0 reset product = 0
        if < 0 min = max * -
        
        max = 1;
        min = -12
        2 3 -2 4 -3
        2 6    4
        
        min = 1
        min = 1
        max = 1
        min = 1
        
        */
        int res = nums[0];
        int max = res;
        int min = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(res, max);
           
        }
        return res;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}