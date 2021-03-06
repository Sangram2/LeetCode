/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root==p || root==q || (p.val<root.val && q.val>root.val) || (p.val>root.val && q.val<root.val)){
    //         return root;
    //     }
    //     else if(p.val<root.val && q.val<root.val){
    //         return lowestCommonAncestor(root.left,p,q);
    //     }
    //     else{
    //         return lowestCommonAncestor(root.right,p,q);
    //     }
    // }--------------------------------> MY SOLUTION.....
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null){
            if(p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            }
            else if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            }
            else{
                //divergent
                return curr;
            }
        }
        
        return null;
    }
}