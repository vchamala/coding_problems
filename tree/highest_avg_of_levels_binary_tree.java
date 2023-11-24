public int highestAvgLevelsBinaryTree(TreeNode root) {
         Queue q = new Queue();
         q.add(root);
         
         int maxAverage = 0;
         in count = 0;
         
         whike (!q.isEmpty()) {
             double qlen = q.size(), row = 0;
             for (int i=0; i<qlen; i++) {
                TreeNode current = q.poll();
                row+=current.val;
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
             }
             int avg = row/qlen;
             maAverage = Math.max(maxAverage, avg);
         }
         return maxAverage;
}
