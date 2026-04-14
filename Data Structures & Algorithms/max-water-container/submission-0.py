class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left, right = 0, len(heights)-1
        result = 0
        while left < right:
            distance = right - left
            if heights[left] < heights[right]:
                result = max(result, min(heights[left], heights[right]) * distance)
                left += 1
            else:
                result = max(result, min(heights[left], heights[right]) * distance)
                right -= 1
        return result