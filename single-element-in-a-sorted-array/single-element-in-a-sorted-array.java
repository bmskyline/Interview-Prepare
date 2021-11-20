class Solution {
    public int singleNonDuplicate(int[] nums) {
        /*
        11 22 33 44 5
        8/2 = 4
        if (nums[4] = nums[4+1])
        search 6 - 8
        6
        
        7
        if (num 7 == num 6)
        search (8,8)
        
        11 2 33 44 55
        if (num[4] == )
        0-4
        num2 == num3
        0 - 2
        
        33 77 10 11 11
        4
        
        */
        
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left+ (right-left)/2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid+1]) {
                    left = mid+2;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == nums[mid-1]) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
        }
        if (left == nums.length)
            return nums[left-1];
        return nums[left];
    }
    /*
    Time complexity : O(logn)
    Space complexity : O(1)
    */
}