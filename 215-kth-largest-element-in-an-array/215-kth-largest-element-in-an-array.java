class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
             i
        5  6 1 3 2 4
        pivot  = 4
        */
        int l = 0;
        int r = nums.length - 1;
        int j = 0;
        while (l <= r) {
            j = quickSelect(nums, l, r);
            if (j == k - 1) {
                return nums[j];
            } else if (j < k - 1) {
                l = j + 1;
            } else {
                r = j - 1;
            }
        }
        return nums[k-1];
    }
    
    int quickSelect(int[] nums, int l, int r) {
        int pivot = nums[r];
        for (int i = l; i < r; i++) {
            if (nums[i] >= pivot) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            }
        }
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        return l;
    }
}