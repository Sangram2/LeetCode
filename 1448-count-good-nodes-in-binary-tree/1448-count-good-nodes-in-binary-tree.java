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
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return count;
    }
    public void dfs(TreeNode node,int minV){
        if(node.val>=minV){
            count++;
        }
        int m1 = Math.max(minV,node.val);
        if(node.left!=null){
            dfs(node.left,m1);
        }
        if(node.right!=null){
            dfs(node.right,m1);
        }
    }
}