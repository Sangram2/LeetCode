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
      if(root==null){
         return new ArrayList<>();
      }
      List<Integer> ans= new ArrayList<>();
      
      Queue<TreeNode> qu = new LinkedList<>();
      qu.add(root);
      
      while(qu.size()!=0){
          int lsize = qu.size();
          for(int i=0;i<lsize;i++){
              TreeNode curr = qu.remove();
              if(i==(lsize-1)){
                  ans.add(curr.val);
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
}