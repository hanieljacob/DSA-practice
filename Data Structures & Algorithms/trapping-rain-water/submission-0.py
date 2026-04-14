class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        result = 0
        max_height = 0
        left_heights = []
        right_heights = []
        for h in height:
            if h < max_height:
                left_heights.append(max_height)
            else:
                left_heights.append(0)
            max_height = max(h, max_height)
        max_height = 0
        for h in height[::-1]:
            if h < max_height:
                right_heights.append(max_height)
            else:
                right_heights.append(0)
            max_height = max(h, max_height)
        for index in range(len(height)):
            if left_heights[index] == 0 or right_heights[n-index-1] == 0:
                continue
            result += min(left_heights[index], right_heights[n-index-1]) - height[index]
        return result
            
