class Solution {
    public int maxSubArray(int[] nums) {
        Integer sum = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (max < sum)
                max = sum;
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
        }
        return Math.max(sum, max);
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}