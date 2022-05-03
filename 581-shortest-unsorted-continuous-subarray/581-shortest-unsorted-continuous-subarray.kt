class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        /*
        2 20 1 5 4
        0 0  1 0 1
        4
        */
        var flag = false
        for (i in 1 until nums.size) {
            if (nums[i] < nums[i-1])
                flag = true
            if (flag)
                min = Math.min(min, nums[i])
        }
        flag = false
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] > nums[i + 1])
                flag = true
            if (flag)
                max = Math.max(max, nums[i])
        }
        var l = nums.size
        var r = 0
        for (i in nums.indices) {
            if (min < nums[i]) {
                l = i
                break
            }     
        }
        for (i in nums.size - 1 downTo 0) {
            if (max > nums[i]) {
                r = i
                break
            }
        }
        return if (r - l < 0) 0 else r - l + 1
    }
}