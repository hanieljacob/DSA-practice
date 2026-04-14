class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        left, right = 0, 0
        characters = set()
        result = 0
        while n > right:
            while s[right] in characters:
                characters.remove(s[left])
                left += 1
            characters.add(s[right])
            result = max(result, right - left + 1)
            right += 1
        return result