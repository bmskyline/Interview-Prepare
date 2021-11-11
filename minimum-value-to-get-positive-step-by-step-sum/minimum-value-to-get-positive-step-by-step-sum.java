class Solution {
    public int minStartValue(int[] nums) {
        /*
        -3 -1 -4 0 2 5
        1 2
        1
        1 - 2- 3
        1 -1 -4
        5
        */
        int min = nums[0];
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (sum < min)
                min = sum;
        }
        if (min >= 0)
            return 1;
        return 1 - min;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}