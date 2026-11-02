class Solution {
    public int minMoves2(int[] nums) {
        /*
        1,2,9,10
        4 3 4 5 select 5
        5 4 3 4 select 6

        1 4 7 8 10 11
        5 2 1 2 4 5 select 6

        1 3
        */

        if (nums.length == 1)
            return 0;
        Arrays.sort(nums);
        int res = 0;
        int target = nums[nums.length/2];
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(target - nums[i]);
        }
        return res;
    }
}