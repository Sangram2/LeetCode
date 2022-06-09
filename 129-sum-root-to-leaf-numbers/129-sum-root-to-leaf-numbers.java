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
    static int ans=0;
    public int sumNumbers(TreeNode root) {
        ans=0;
        helper(root,0);
        
        return ans;
    }
    
    public void helper(TreeNode root,int num){
        if(root.left!=null && root.right!=null){
            helper(root.left,(num*10)+root.val);
            helper(root.right,(num*10)+root.val);        }
        else if(root.left!=null){
            helper(root.left,(num*10)+root.val);
        }
        else if(root.right!=null){
            helper(root.right,(num*10)+root.val);  
        }
        else{
            ans+= (num*10)+root.val;
            return;
        }
    }
}