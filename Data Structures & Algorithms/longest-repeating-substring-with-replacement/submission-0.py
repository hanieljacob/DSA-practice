class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left, right = 0, 0
        n = len(s)
        character_counts = defaultdict(int)
        max_count = 0
        result = 0
        while n > right:
            character_counts[s[right]] += 1
            max_count = max(max_count, character_counts[s[right]])
            while (right - left + 1) - max_count > k:
                character_counts[s[left]] -= 1
                left += 1
            result = max(result, right-left+1)
            right += 1
        return result