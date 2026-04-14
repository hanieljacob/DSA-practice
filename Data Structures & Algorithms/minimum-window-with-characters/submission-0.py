class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_counter = Counter(t)
        s_counter = defaultdict(int)
        matches = 0
        required_matches = len(t_counter)
        n = len(s)
        left, right = 0, 0
        result = ""
        min_length = float('inf')
        for right in range(n):
            s_counter[s[right]] += 1
            if s_counter[s[right]] == t_counter[s[right]]:
                matches += 1
            while matches == required_matches:
                if right-left+1 < min_length:
                    result = s[left:right+1]
                    min_length = right-left+1
                if s_counter[s[left]] == t_counter[s[left]]:
                    matches -= 1
                s_counter[s[left]] -= 1
                left += 1
            print(s_counter)
        return result


                