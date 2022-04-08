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
    public int min(TreeNode node){
        TreeNode curr = node;
        while(curr.left != null)
            curr =curr.left;
        return curr.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root  == null){
            return null;
        }
        
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            //==
            //0 child ||  1 child
            if(root.left == null || root.right == null ){
                return root.left != null ? root.left : root.right;
            }
            
            // 2   child
            int minEle = min(root.right);
            root.val = minEle;
            root.right = deleteNode(root.right, minEle);
            
        }
        return root;
    }
}