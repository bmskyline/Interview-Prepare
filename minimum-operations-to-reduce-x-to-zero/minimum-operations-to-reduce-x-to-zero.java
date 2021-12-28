class Solution {
    public int minOperations(int[] nums, int x) {
        /*
        1 1 4 2 3
        1 2 6 8 11
        x = 5
        
        3 2 20 1  1 3
        3 5 28 29 30 33
        x = 10 
        10 - 33 + 33 = 10
        10 - 33 + 30 = 7
        10 - 33 + 29 = 6
        10 - 33 + 28 = 5
        */
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        Map<Integer, Integer> map = new HashMap();
        map.put(nums[0], 0);
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
            map.put(pre[i], i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = pre.length - 1; i >= 0; i--) {
            if (map.containsKey(x - pre[pre.length - 1] + pre[i])) {
                min = Math.min(min, pre.length - i - 1 + map.get(x - pre[pre.length - 1] + pre[i]) + 1);
            }
            if (pre[pre.length - 1] - pre[i] == x) {
                min = Math.min(min, pre.length - i - 1);
            }
            map.remove(pre[i]);
            
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
}