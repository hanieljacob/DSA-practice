class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left, right = 0, len(heights)-1
        result = 0
        while left < right:
            distance = right - left
            result = max(result, min(heights[left], heights[right]) * distance)
            if heights[left] < heights[right]:
                left += 1
            else:
                right -= 1
        return result