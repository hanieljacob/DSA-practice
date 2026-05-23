class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)
        result = [-1]*n
        max_element = arr[n-1]
        for i in range(n-2,-1,-1):
            result[i] = max_element
            max_element = max(max_element, arr[i])
        return result