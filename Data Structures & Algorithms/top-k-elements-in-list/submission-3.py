import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = Counter(nums)
        heap = []
        result = []
        for key, value in counter.items():
            heapq.heappush(heap, (-value, key))
        while k > 0:
            _, value = heapq.heappop(heap)
            result.append(value)
            k -= 1
        return result

        
        
        