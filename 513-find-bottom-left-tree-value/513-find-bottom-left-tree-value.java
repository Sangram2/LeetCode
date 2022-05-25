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
    public List<Integer> leftSideView(TreeNode root) {
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
              if(i==0){
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
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> lView = leftSideView(root);
        int size = lView.size();
        return lView.get(size-1);
    }
}