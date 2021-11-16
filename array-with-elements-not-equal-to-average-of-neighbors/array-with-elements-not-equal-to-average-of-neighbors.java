class Solution {
    public int[] rearrangeArray(int[] nums) {
        /*
        12345
        1 2 
        2-1 = 3-2
        swap 3 ->1 2 4 3 5
        6 2 0 9 7
        6 2 0 9 7
        2 3 4 5 1
        2 4 3 5 1
        1 2 3 5
          3 2 5
        
        0 2 4 5  3  1
        0 2 5 4 3 1
        4 3 6 9 7
        4 6 3 9 7
        
        1 3 11 6 2 4
        1 3 6 11
        3 1 6 11 2 4
        */
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] + nums[i+1] == nums[i]*2) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i - 1] + nums[i+1] == nums[i]*2) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
        return nums;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}