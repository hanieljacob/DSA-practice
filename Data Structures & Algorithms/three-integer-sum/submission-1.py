class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        result = set()
        for i in range(n):
            k = n-1
            j = i+1
            while k > j:
                total_sum = nums[i] + nums[j] + nums[k]
                if total_sum > 0:
                    k -= 1
                elif total_sum < 0:
                    j += 1
                else:
                    sorted_triplet = tuple(sorted([nums[i], nums[j], nums[k]]))
                    result.add(sorted_triplet)
                    k -= 1
                    j += 1
        return list(result)
