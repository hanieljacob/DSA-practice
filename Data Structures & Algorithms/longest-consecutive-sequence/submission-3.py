class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        nums_set = set(nums)
        result = 1
        for num in nums:
            if num-1 in nums_set:
                continue
            size = 1
            while num+1 in nums_set:
                num += 1
                size += 1
                result = max(result, size)
        return result
