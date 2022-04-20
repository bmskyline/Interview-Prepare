class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val set = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (set.contains(target - nums[i]))
                return intArrayOf(i, set.get(target - nums[i]) ?: 0)
            set.put(nums[i], i)
        }
        return intArrayOf(0,0);
    }
}