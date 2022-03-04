class Solution {
    public int missingElement(int[] nums, int k) {
        
        /*
        4 7 9 10
        0 2 3 5-2
        5
        */
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
        int t = count(nums, l);
        if (t >= k)
            l = l - 1;
        t = count(nums, l);
        while (t < k) {
            nums[l]++;
            t++;
        }
        return nums[l];
    }
    
    int count(int[] nums, int m) {
        return nums[m] - nums[0] - 1 - m +1;
    }
}