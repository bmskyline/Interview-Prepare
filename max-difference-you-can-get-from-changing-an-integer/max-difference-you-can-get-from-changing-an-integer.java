class Solution {
    public int maxDiff(int num) {
        /*
        x = 5
        y = 9
        999
        555
        444*2
        123456
        1 9
        923456
        103456
        820000
        
        10000
        1 9
        90000
        
        9288
        1288
        9988
        8000
        1999
        9999
        1099
        8900
        */
        char[] nums = String.valueOf(num).toCharArray();
        char[] nums2 = String.valueOf(num).toCharArray();
        int i = 0;
        int first = 0;
        char replaceFirst = 'x';
        char replaceSecond = 'x';
        int second = 0;
        while (i < nums.length) {
            if (replaceFirst == 'x') {
                if (nums[i] != '9') {
                    replaceFirst = nums[i];
                    nums[i] = '9';
                }
            } else {
                if (nums[i] == replaceFirst) {
                    nums[i] = '9';
                }
            }
            i++;
        }
        first = Integer.parseInt(new String(nums));
        i = 1;
        char become = 'y';
        if (nums2[0] != '1') {
            replaceSecond = nums2[0];
            nums2[0] = '1';
            become = '1';
        }
        while (i < nums.length) {
            if (replaceSecond == 'x') {
                if (nums2[i] != '0' && nums2[i] != '1') {
                    replaceSecond = nums2[i];
                    nums2[i] = '0';
                    become = '0';
                }
            } else {
                if (nums2[i] == replaceSecond) {
                    nums2[i] = become;
                }
            }
            i++;
        }
        second = Integer.parseInt(new String(nums2));
        return first - second;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}