import heapq
class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.stream = []
        self.k = k
        for num in nums:
            heapq.heappush(self.stream, -num)

    def add(self, val: int) -> int:
        print(self.stream)
        poped_elements = []
        result = None
        heapq.heappush(self.stream, -val)
        for i in range(self.k):
            result = heapq.heappop(self.stream)
            poped_elements.append(result)
        for element in poped_elements:
            heapq.heappush(self.stream, element)
        return -result
