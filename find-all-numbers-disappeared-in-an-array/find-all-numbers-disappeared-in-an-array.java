class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
         4 3 2 7 8 2 3 1
         -4 -3 -2 -7 8 2 -3 -1 
        */
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i+1);
        }
        return res;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}