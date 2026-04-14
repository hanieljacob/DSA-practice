class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        adj_list = defaultdict(list)
        visited = set()
        for node1, node2 in edges:
            adj_list[node1].append(node2)
            adj_list[node2].append(node1)
        
        def dfs(node, prev):
            nonlocal visited
            if node in visited:
                return False
            visited.add(node)
            for neighbor in adj_list[node]:
                if neighbor == prev: 
                    continue
                result = dfs(neighbor, node)
                if result == False:
                    return False
            return True

        result = dfs(0, -1)
        return result if len(visited) == n else False
            