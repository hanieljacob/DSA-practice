class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l, r = 0, len(heights)-1
        result = 0
        while l < r:
            distance = r - l    
            height = min(heights[l], heights[r])
            result = max(result, height*distance)
            print(height*distance)
            if (heights[l] > heights[r]):
                r -= 1
            else:
                l += 1
        return result