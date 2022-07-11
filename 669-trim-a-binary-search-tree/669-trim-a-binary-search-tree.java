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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(low>high || root==null){
            return  null;
        }
        
        if(high<root.val){
            TreeNode Tree = trimBST(root.left,low,high);
            return Tree;
        }
        if(low>root.val){
            TreeNode Tree = trimBST(root.right,low,high);
            return Tree;
        }
        else{
            root.left = trimBST(root.left,low,root.val-1);
            root.right = trimBST(root.right,root.val+1,high);
            return root;
        }
    }
}