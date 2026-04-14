"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        node_map = {}
        temp, result = head, head
        while temp:
            node_map[temp] = Node(temp.val)
            temp = temp.next
        while head:
            if head.random:
                node_map[head].random = node_map[head.random]
            if head.next:
                node_map[head].next = node_map[head.next]
            else:
                node_map[head].next = None
            head = head.next
        return None if not node_map else node_map[result]
