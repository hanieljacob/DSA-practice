class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        result = set()
        for index in range(n):
            while index >= 1 and index < n and nums[index] == nums[index-1]:
                index += 1
            left, right = index+1, n-1
            while left < right:
                total = nums[index] + nums[left] + nums[right]
                if total == 0:
                    triplet = (nums[index], nums[left], nums[right])
                    result.add(triplet)
                    left += 1
                    right -= 1
                elif total > 0:
                    right -= 1
                else:
                    left += 1
        return [element for element in result]