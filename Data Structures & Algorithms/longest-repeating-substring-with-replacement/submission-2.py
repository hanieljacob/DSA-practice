class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        character_counts = defaultdict(int)
        max_character_count = 0
        result = 0
        l, r = 0, 0
        while r < len(s):
            character_counts[s[r]] += 1
            max_character_count = max(max_character_count, character_counts[s[r]])
            while l<r and r-l+1-max_character_count > k:
                character_counts[s[l]] -= 1
                l += 1
            result = max(result, r-l+1)
            r += 1
        return result



