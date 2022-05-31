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
    
    public int leftheight(TreeNode node){
        if(node == null)
            return 0;
        int ans=1;
        while(node.left!=null){
            node=node.left;
            ans++;
        }
        return ans;
    } 
    public int rightheight(TreeNode node){
        if(node == null)
            return 0;
        int ans=1;
        while(node.right!=null){
            node=node.right;
            ans++;
        }
        return ans;
    } 
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int lh=leftheight(root.left);
        int rh=rightheight(root.right);
        
        if(rh==lh){
            // return (int)Math.pow(2,rh+1)-1;
            return (1<<(lh+1))-1;
        }
        else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
}