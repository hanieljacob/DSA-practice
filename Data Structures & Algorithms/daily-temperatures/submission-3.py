class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        stack = []
        for index in range(len(temperatures)-1, -1, -1):
            if stack:
                while stack and temperatures[index] >= temperatures[stack[-1]]:
                    stack.pop()
                if stack:
                    result[index] = stack[-1] - index
            stack.append(index)
        return result