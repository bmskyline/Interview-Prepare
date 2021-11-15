class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        /*
        123456
        1 2 6 10
        
        1 2 6 10
        1 2 3 3
        
        */
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] pos = new int[nums.length];
        count[0] = 1;
        pos[0] = -1;
        int max = 1;
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            count[i] = 1;
            pos[i] = -1;
            int lar = 0;
            for (int f = i - 1; f >= 0; f--) {
                 if (nums[i] % nums[f] == 0 && count[f] >= lar) {
                     count[i] = count[f] + 1;
                     lar = count[f];
                     pos[i] = f;
                 }
            }
            if (count[i] > max) {
                max = count[i];
                idx = i;
            }
        }
        List<Integer> res = new ArrayList();
        while (idx >= 0) {
            res.add(nums[idx]);
            idx = pos[idx];
        }
        return res;
    }
    /*
    Time complexity : O(n^2)
    Space complexity : O(n)
    */
}