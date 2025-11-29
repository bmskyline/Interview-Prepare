class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        sum = 0
        for num in nums:
            sum += num
        return sum % k