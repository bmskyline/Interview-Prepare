class Solution {
    public int monotoneIncreasingDigits(int n) {
        /*
        123154
        122999
        15864
        15799
        32
        29
        10
        9
        332
        299
        */
        char[] nums = String.valueOf(n).toCharArray();
        boolean change = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (change) {
                nums[i] = '9';
            } else {
                if (nums[i] > nums[i+1]) {
                    
                    int j = i - 1;
                    while (j >= 0 && nums[j] == nums[i]) {
                        j--;
                    }
                    nums[j + 1] -= 1;
                    i = j + 1;
                    change = true;
                }
            }
            
        }
        if (change) {
            nums[nums.length - 1] = '9';
        }
        return Integer.parseInt(new String(nums));
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}