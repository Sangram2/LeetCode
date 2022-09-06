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
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
    
    boolean dfs(TreeNode node){
        
        if(node == null){
            return false;
        }
        
        
        boolean l = dfs(node.left);
        boolean r = dfs(node.right);
        if(!l){
            node.left = null;
        }
        if(!r){
            node.right = null;
        }
        
        if(r || l || node.val == 1){
            return true;
        }
        return false;
    }
}