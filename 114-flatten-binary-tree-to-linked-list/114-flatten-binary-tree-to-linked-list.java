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
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        
        TreeNode l=helper(root.left);
        TreeNode r=helper(root.right);
        if(l!=null){
            TreeNode temp=l;
        
            while(temp.right!=null){
                temp=temp.right;
            }
            temp.right=r;
        }else{
            l=r;
        }
        
        root.right=null;
        root.left=null;
        root.right=l;
        
    }
    public TreeNode helper(TreeNode root){
        if(root==null){
            return null;
        }
        
        TreeNode node=new TreeNode(root.val);
        
        node.right=helper(root.left);
        TreeNode temp=node;
        while(temp.right!=null){
            temp=temp.right;
        }
        temp.right=helper(root.right);
        return node;
       
    }
}