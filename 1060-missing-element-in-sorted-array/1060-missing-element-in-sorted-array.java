class Solution {
    public int missingElement(int[] nums, int k) {
        
        /*
        4 7 9 10
        0 2 3 5-2
        5
        */
        if (k > count(nums, nums.length - 1))
          return nums[nums.length - 1] + k - count(nums, nums.length - 1);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (count(nums, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l-1] + k - count(nums, l - 1);
    }
    
    int count(int[] nums, int m) {
        return nums[m] - nums[0] - 1 - m +1;
    }
}