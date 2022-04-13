class Solution {
    public int minPairSum(int[] nums) {
        /*
        2 33 5
        2 3 4 4 5 6
        8
        2 3 3 3 3 7
        */
        int n = nums.length;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, nums[i] + nums[n - i - 1]);
        }
        return max;
    }
}