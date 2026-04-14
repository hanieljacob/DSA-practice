class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        nse, pse, stack = [n]*n, [-1]*n, []
        result = 0
        for index, height in enumerate(heights):
            while stack and heights[stack[-1]] >= height:
                    stack.pop()
            if stack:
                pse[index] = stack[-1]
            stack.append(index)
        stack = []
        for index in range(n-1, -1, -1):
            while stack and heights[stack[-1]] >= heights[index]:
                stack.pop()
            if stack:
                nse[index] = stack[-1]
            stack.append(index)
        print(nse)
        print(pse)
        for index in range(n):
            value = heights[index] * (nse[index] - pse[index] - 1)
            result = max(result, value)
        return result
