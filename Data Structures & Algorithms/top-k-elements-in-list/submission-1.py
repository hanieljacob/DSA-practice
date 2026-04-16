class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency_map = defaultdict(int)
        max_value = len(nums)
        result = []
        for num in nums:
            frequency_map[num] += 1
        inverse_freq_map = defaultdict(list)
        for key, value in frequency_map.items():
            inverse_freq_map[value].append(key)
        for freq in range(max_value, -1, -1):
            for value in inverse_freq_map[freq]:
                result.append(value)
                k -= 1
                if k == 0:
                    return result
        return result
            
        
        
        