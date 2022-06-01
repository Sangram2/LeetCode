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
    static int Max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        Max=Integer.MIN_VALUE;
        solve(root);
        return Max;
    }
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=solve(root.left);
        int right=solve(root.right);
        int val=Math.max(left,0)+Math.max(right,0)+root.val;
        Max=Math.max(Max,val);
        return root.val+Math.max(Math.max(left,0),Math.max(right,0));
    }
}
// class Solution {
//      public int rootToNode(TreeNode root)
//     {
//         if(root == null){
//             return 0;
//         }
        
//         int left = rootToNode(root.left);
//         int right = rootToNode(root.right);

//         int left_dash = Math.max(0, left);
//         int right_dash = Math.max(0, right);

//         return Math.max(left_dash, right_dash) + root.val;
//     }
//     public int maxPathSum(TreeNode root) {
//         if(root==null){
//             return Integer.MIN_VALUE;
//         }
//         if(root.left==null && root.right==null){
//             return root.val;
//         }
//         int leftans=rootToNode(root.left);
//         int rightans=rootToNode(root.right);
//         int val=Math.max(leftans,0)+Math.max(rightans,0)+root.val;
        
        
//         int leftcall=maxPathSum(root.left);
//         int rightcall=maxPathSum(root.right);
//         return Math.max(val,Math.max(leftcall,rightcall));
//     }
// }