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
    public int kthSmallest(TreeNode root, int k) {
        int u = 0;
        
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left == null){
                u++;
                if(u==k){
                    return curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode iop = curr.left;
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    iop.right = curr; // making the thread
                    curr = curr.left;
                } else {
                    
                    u++;
                    iop.right = null;
                    if(u==k){
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return Integer.MIN_VALUE;
        
        
    }
}