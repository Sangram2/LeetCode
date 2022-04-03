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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root!=null && root.val==target && root.left==null && root.right==null){
            return null;
        }
        helper(root,null,false,target);
        if(root!=null && root.val==target && root.left==null && root.right==null){
            return null;
        }
        return root;
    }
    public void helper(TreeNode root,TreeNode parent,boolean left,int target){
        if(root==null){
            return;
        }
        helper(root.left,root,true,target);
        helper(root.right,root,false,target);
        
        if(root.val==target && root.left==null && root.right==null){
            if(parent!=null){
                if(left){
                    parent.left=null;
                }
                else{
                    parent.right=null;
                }
            }
        }
    }
}