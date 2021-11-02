class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        /*
        0 1 1 2 2 3
        
        */
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
        /*
        Time complexity : O(n)
        Space complexity : O(n)
        */
    }
}