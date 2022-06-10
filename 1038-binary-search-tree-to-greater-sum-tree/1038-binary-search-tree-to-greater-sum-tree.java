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
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null){
            return null;
        }
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.right);
        
        root.val+=sum;
        sum=root.val;
        
        helper(root.left);
    }
    
}


//Method 2
// class Solution {
//     public TreeNode bstToGst(TreeNode root) {
//         if(root==null){
//             return null;
//         }
//         int sum=findSum(root);
        
//         TreeNode curr=root;
//         while(curr!=null){
//             if(curr.left==null){
//                 int data=curr.val;
//                 curr.val=sum;
//                 sum-=data;
//                 curr=curr.right;
                
//             }
//             else{
//                 TreeNode temp=curr.left;
//                 while(temp.right !=null && temp.right!=curr){
//                     temp=temp.right;
//                 }
//                 if(temp.right==null){
//                     temp.right=curr;
//                     curr=curr.left;
//                 }
//                 else{
//                     int data=curr.val;
//                     curr.val=sum;
//                    temp.right=null;
//                     sum-=data;
//                     curr=curr.right;
                    
                    
//                 }
//             }
//         }
//         return root;
//     }
//      public int findSum(TreeNode root){
//         if(root==null){
//             return 0;
//         }
//         int left=findSum(root.left);
//         int right=findSum(root.right);
//         return root.val+left+right;
//     }
// }