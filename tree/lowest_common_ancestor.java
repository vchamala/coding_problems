/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // 1. Search the 2 nodes in the tree
    // 1.1-if node found return true
    // 1.2-if node not found - return null

    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        
        if (node == null) {
            return null;
        }
        
        if (node.val == p.val && node.val == q.val) {
            return node;
        }
        
        TreeNode leftRca = lowestCommonAncestor(node.left, p, q);
        TreeNode rightRca = lowestCommonAncestor(node.right, p, q);
        
        if (leftRca != null && rightRca != null) {
            return node;
        }
        
        return (leftRca != null) ? leftRca : rightRca;
        
    }
}
