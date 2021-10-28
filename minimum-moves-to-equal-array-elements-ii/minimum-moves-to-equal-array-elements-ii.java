class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < mid) {
                count += nums[mid] - nums[i]; 
            }
            if (i > mid) {
                count += nums[i] - nums[mid];
            }
        }
        return count;
    }
    
    /*
    Time complexity : O(nlogn)
    Space complexity : O(logn); 
    */
}