class Solution {
    fun minMoves(nums: IntArray): Int {
        /*
            2 steps:
            - First: we find the largest number
            - Second: sum of move
        */
        var largest = 0
        var res = 0
        for (num in nums) {
            if (num > largest)
                largest = num
        }
        for (num in nums) {
            res += largest - num
        }
        return res
    }
}