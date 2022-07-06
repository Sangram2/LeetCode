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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
            
        }
        if(root2==null){
            return root1;
        }
        
        
        return solver(root1,root2);
    }
    TreeNode solver(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null){
            return null;
        }
        if(node1==null || node2==null){
            if(node1==null){
                return node2;
            }
            return node1;
        }
        TreeNode root = new TreeNode(node1.val+node2.val);
        root.left = solver(node1.left,node2.left);
        root.right = solver(node1.right,node2.right);
        return root;
    } 
}