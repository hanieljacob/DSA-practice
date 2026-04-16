class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left_products = []
        right_products = []
        curr = 1
        for num in nums:
            left_products.append(curr)
            curr *= num
        curr = 1
        for num in nums[::-1]:
            right_products.append(curr)
            curr = curr*num
        return [left_products[i] * right_products[len(nums)-i-1] for i in range(len(nums))]