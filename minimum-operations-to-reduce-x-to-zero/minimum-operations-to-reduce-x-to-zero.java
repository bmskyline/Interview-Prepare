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
        int maxLength = -1;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int length = nums.length;
        int[] prefixSums = new int[length];
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            prefixSums[i] = sum;
            map.put(sum, i);
        }
        int remainSum = sum - x;
        for (int i = 0; i < length; i++) {
            int prefixSum = prefixSums[i];
            if (map.containsKey(prefixSum - remainSum))
                maxLength = Math.max(maxLength, i - map.get(prefixSum - remainSum));
        }
        if (maxLength == -1)
            return -1;
        else
            return length - maxLength;
    }
    
}