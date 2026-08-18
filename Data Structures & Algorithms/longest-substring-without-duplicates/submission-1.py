class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hash_set = set()
        l, r = 0, 0
        result = 0
        while r < len(s):
            while s[r] in hash_set:
                hash_set.remove(s[l])
                l += 1
            result = max(result, r-l+1)
            hash_set.add(s[r])
            r += 1
        return result
            
