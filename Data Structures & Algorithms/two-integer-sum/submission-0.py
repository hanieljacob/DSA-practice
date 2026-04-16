class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen_map = {}
        for index, num in enumerate(nums):
            if target - num in seen_map:
                return [seen_map[target-num], index]
            seen_map[num] = index