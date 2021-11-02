class Solution {
    public int findMaxLength(int[] nums) {
        
        /*
         0011
        01210 = 4
          10
        0-10 = 2
        101
        0 -1 0 -1 = 2
        1111100010
        -1-2-3-4-5-4-3-2-3-2 9-1 = 8
        */
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                int res = i+1 - map.get(sum);
                if (res > max)
                    max = res;
            } else {
                map.put(sum, i+1);
            }
        }
        return max;
        /*
        Time complexity : O(n)
        Space complexity : O(n)
        */
    }
}