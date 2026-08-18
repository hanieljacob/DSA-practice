class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        buy = prices[0]
        for i in range(1, len(prices)):
            if prices[i] > buy:
                result = max(result, prices[i] - buy)
            else:
                buy = prices[i]
        return result
