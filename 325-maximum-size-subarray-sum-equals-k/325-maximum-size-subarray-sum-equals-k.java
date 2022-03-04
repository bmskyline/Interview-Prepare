class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        /*
        1 -1 5 -2 3 
        k - 3
        5
        0  1 0 5  3 6
        
        */
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        map.put(0, 0);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i + 1);
            }
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i + 1 - map.get(sum - k));
            }
        }
        return max;
    }
}