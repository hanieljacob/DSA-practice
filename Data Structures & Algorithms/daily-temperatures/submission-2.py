class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * len(temperatures)
        for index in range(len(temperatures)-1,-1,-1):
            if not stack:
                stack.append(index)
                continue
            while stack and temperatures[index] >= temperatures[stack[-1]]:
                stack.pop()
            if stack:
                result[index] = stack[-1] - index
            stack.append(index)
        return result
            