class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        left, right = 0, 0
        window_size = len(s1)
        n = len(s2)
        s1_counter = Counter(s1)
        s2_counter = defaultdict(int)
        matches = 0
        required_matches = len(s1_counter)
        while right < n:
            s2_counter[s2[right]] += 1
            if s2_counter[s2[right]] == s1_counter[s2[right]]:
                matches += 1
            if matches == required_matches:
                return True
            if right - left + 1 == window_size:
                if s2_counter[s2[left]] == s1_counter[s2[left]]:
                    matches -= 1
                s2_counter[s2[left]] -= 1
                left += 1
            right += 1
        return False
