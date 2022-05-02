class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var idx = 0;
        for (i in nums.indices) {
            if (nums[i] % 2 == 0) {
                val temp = nums[idx]
                nums[idx++] = nums[i]
                nums[i] = temp
            }
        }
        return nums
    }
}