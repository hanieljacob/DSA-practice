class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)
        for s in strs:
            current_list = groups[tuple(sorted(s))]
            current_list.append(s)
            groups[tuple(sorted(s))] = current_list
        return list(groups.values())
    
