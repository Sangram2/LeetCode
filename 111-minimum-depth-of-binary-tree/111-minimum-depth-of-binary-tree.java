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
    int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,1);
        return ans;
    }
    void dfs(TreeNode node, int d){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            ans = Math.min(ans,d);
        }
        if(d+1<=ans){
            dfs(node.left,d+1);
            dfs(node.right,d+1); 
        }
        
    }
    
}