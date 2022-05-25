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
    public int leftSideView(TreeNode root) {
      
      int ans = root.val;
      
      Queue<TreeNode> qu = new LinkedList<>();
      qu.add(root);
      
      while(qu.size()!=0){
          int lsize = qu.size();
          for(int i=0;i<lsize;i++){
              TreeNode curr = qu.remove();
              if(i==0){
                  ans=curr.val;
              }
              if(curr.left!=null){
                  qu.add(curr.left);
              }
              if(curr.right!=null){
                  qu.add(curr.right);
              }
          }
      }
      return ans;
    }
    public int findBottomLeftValue(TreeNode root) {
        return leftSideView(root);
        
    }
}