class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.size = [1] * n  
    
    def findUltimateParent(self, node):
        if self.parent[node] == node:
            return node
        self.parent[node] = self.findUltimateParent(self.parent[node])
        return self.parent[node]

    def union(self, node1, node2):
        u_parent1 = self.findUltimateParent(node1)
        u_parent2 = self.findUltimateParent(node2)

        if u_parent1 == u_parent2:
            return

        if self.size[u_parent1] >= self.size[u_parent2]:
            self.parent[u_parent2] = u_parent1
            self.size[u_parent1] = self.size[u_parent1] + self.size[u_parent2]
        elif self.size[u_parent1] < self.size[u_parent2]:
            self.parent[u_parent1] = u_parent2
            self.size[u_parent2] = self.size[u_parent1] + self.size[u_parent2]


class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        uf = UnionFind(n)
        components = n  
        for u, v in edges:
            pu, pv = uf.findUltimateParent(u), uf.findUltimateParent(v)
            if pu != pv:
                uf.union(u, v)
                components -= 1  # merging two components

        return components
        