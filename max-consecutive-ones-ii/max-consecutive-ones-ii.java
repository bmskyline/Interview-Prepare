class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1)
            return 1;
        List<Integer> list = new ArrayList();
        int cur = 0;
        for (int x : nums) {
            if (x == 0) {
                if (cur > 0) {
                    list.add(cur);
                    cur = 0;
                }
                    
                list.add(0);
            } else {
                cur++;
            }
        }
        if (cur > 0)
            list.add(cur);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                if (i == 0)
                    max = Math.max(max, 1 + list.get(1));
                else if (i == list.size() - 1) {
                    max = Math.max(max, 1 + list.get(i - 1));
                } else {
                    max = Math.max(max, 1 + list.get(i-1) + list.get(i+1));
                }
            }
        }
        return max == 0 ? nums.length : max;
    }
}