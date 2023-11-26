public Solution {

  TreeNode newRoot;

  public Solution(TreeNode newRoot) {
           this.newRoot = newRoot;
  }  

  public cloneTree(TreeNode root) {
           // now, clone each node in a recursive manner..
           cloneTree(root, true);
           return newRoot;
  }
       
  private cloneNode(TreeNode node, boolean isRoot) {
           TreeNode newNode = new TreeNode(node.val, node.left, node.right);
           if (isRoot) {
              newRoot = newNode;
              isRoot = false;
           }
           cloneNode(node.left, isRoot);
           cloneNode(node.right, isRoot);
  }
}
