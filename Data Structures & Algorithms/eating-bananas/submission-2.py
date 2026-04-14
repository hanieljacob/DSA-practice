class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:

        def can_eat(rate):
            total_time = 0
            for pile in piles:
                total_time += math.ceil(pile/rate)
            return total_time <= h

        left, right = 1, max(piles)
        
        while left <= right:
            mid = (left+right)//2
            if can_eat(mid):
                right = mid-1
            else:
                left = mid+1

        return left

        