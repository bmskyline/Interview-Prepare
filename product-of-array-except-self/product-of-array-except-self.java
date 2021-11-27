class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1 2 3 4 = 24  -> aws = 24 12 8 6
        // 9 ->  count0 = 1 ->  0 0 0 9 
        int mul = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                mul *= nums[i];
            else {
                count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count > 0)
                if (nums[i] == 0 && count == 1) {
                    nums[i] = mul;
                } else {
                    nums[i] = 0;
                } 
            else {
                nums[i] = mul / nums[i];
            }
        }
        return nums;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}