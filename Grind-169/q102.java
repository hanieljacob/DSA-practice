import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<size;i++){
                TreeNode currentNode = nodes.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left != null)
                    nodes.offer(currentNode.left);
                if(currentNode.right != null)
                    nodes.offer(currentNode.right);
            }
            ans.add(currentLevel);
            currentLevel = new ArrayList<>();
        }
        return ans;
    }
}