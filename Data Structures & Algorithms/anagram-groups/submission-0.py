class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)
        for string in strs:
            character_counter = [0]*26
            for char in string:
                character_counter[ord(char) - ord('a')] += 1
            groups[tuple(character_counter)].append(string)
        return [value for _, value in groups.items()]
    
