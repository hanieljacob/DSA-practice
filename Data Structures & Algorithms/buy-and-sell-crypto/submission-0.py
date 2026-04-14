class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy, sell = -1, -1
        result = 0
        for price in prices:
            if buy == -1:
                buy = price
            else:
                if price > buy:
                    result = max(result, price-buy)
                else:
                    buy = price
        return result

