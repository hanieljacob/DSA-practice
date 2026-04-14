class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums)-1
        result = float('inf')
        if nums[0] < nums[-1]:
            return nums[0]
        while left <= right:
            mid = (left+right)//2
            if nums[mid] >= nums[left]:
                result = min(result, nums[left])
                left = mid+1
            else:
                result = min(result, nums[mid])
                right = mid-1
        return result