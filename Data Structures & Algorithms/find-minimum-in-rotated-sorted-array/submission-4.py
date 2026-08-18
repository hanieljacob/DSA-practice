class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1
        min_value = float('inf')
        while l <= r:
            mid = (l + r)//2
            if nums[mid] >= nums[l]:
                min_value = min(min_value, nums[l])
                l = mid+1
            else:
                min_value = min(min_value, nums[mid])
                r = mid-1
        return min_value