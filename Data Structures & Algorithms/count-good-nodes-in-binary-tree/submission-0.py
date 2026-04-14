# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        good_nodes = 0
        max_value = root.val
        def dfs(root, max_value):
            nonlocal good_nodes
            if not root:
                return
            if root.val >= max_value:
                good_nodes += 1
            dfs(root.left, max(max_value, root.val))
            dfs(root.right, max(max_value, root.val))
        dfs(root, max_value)
        return good_nodes