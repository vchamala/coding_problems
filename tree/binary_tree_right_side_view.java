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
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) { return new ArrayList<Integer>(); }
        
        List<Integer> rightSideVals = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            
            for (int i=0; i<levelLength; i++) {
                TreeNode n = queue.poll();
                
                if (i == levelLength-1) {
                    rightSideVals.add(n.val);
                }
                
                if (n.left != null) {
                    queue.add(n.left);
                }
                
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
        }
        return rightSideVals;
    }
}
