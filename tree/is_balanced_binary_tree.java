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
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) { return true; }
            
        int heightOfLeftSubTree = heightOfSubTree(root.left);
        int heightOfRightSubTree = heightOfSubTree(root.right);
    
        return Math.abs(heightOfLeftSubTree - heightOfRightSubTree) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int heightOfSubTree(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(heightOfSubTree(node.left), heightOfSubTree(node.right)) + 1;        
    }
    
}
