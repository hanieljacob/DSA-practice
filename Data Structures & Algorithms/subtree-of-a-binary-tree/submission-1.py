# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def is_subroot(root, subRoot):
            if not root and not subRoot:
                return True
            if not root or not subRoot or root.val!=subRoot.val:
                return False
            left = is_subroot(root.left, subRoot.left)
            right = is_subroot(root.right, subRoot.right)
            return left and right

        def dfs(root, subRoot):
            if not root:
                return False
            left = dfs(root.left, subRoot)
            right = dfs(root.right, subRoot)
            if root.val == subRoot.val:
                return left or right or is_subroot(root, subRoot)
            return left or right
        
        return dfs(root, subRoot)
        