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
    public TreeNode invertTree(TreeNode root) {
        TreeNode ans = solver(root);
        return ans;
    }
    TreeNode solver(TreeNode node){
        if(node==null){
            return null;
        }
        
        TreeNode left = solver(node.left);
        TreeNode right = solver(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}