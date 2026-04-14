class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        left, right = 0, k
        n = len(nums)
        result = []
        max_heap = []
        for index in range(k):
            heapq.heappush(max_heap, (-nums[index], index))
        result.append(-max_heap[0][0])
        while right < n:
            heapq.heappush(max_heap, (-nums[right], right))
            left += 1
            while max_heap:
                element, index = heapq.heappop(max_heap)
                if left <= index:
                    result.append(-element)
                    heapq.heappush(max_heap, (element, index))
                    break
            right += 1
        return result
            