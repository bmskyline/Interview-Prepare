class Solution {
    public void sortColors(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (j > 0 && nums[j-1] > nums[j]) {
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j = j - 1;
            }
            i = i + 1;
        }
    }
}