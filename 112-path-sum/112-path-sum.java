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
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        dfs(root,root.val,targetSum);
        return ans;
        
    }
    
    
    void dfs(TreeNode node,int sum,int tSum){
        if(node==null){
            return;
        }
        else if(node.left==null && node.right==null){
            if(sum==tSum){
                ans=true;
            }
        }
        if(node.left!=null){
             dfs(node.left,sum+node.left.val,tSum);
        }
        if(node.right!=null){
            dfs(node.right,sum+node.right.val,tSum);
        }
       
        
    }
}