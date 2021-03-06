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


//Recursive approach
// class Solution {
//     public void preOrder(TreeNode root,List<Integer> ans){
//         if(root==null){
//             return;
//         }
//         ans.add(root.val);
//         preOrder(root.left,ans);
//         preOrder(root.right,ans);
        
//     }
    
//     public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ans=new ArrayList<>();
//         preOrder(root,ans);
//         return ans;
//     }
// }


//Morris Traversal--MyApproach
class Solution {
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        
        while(curr != null){
            if(curr.left!=null){
                TreeNode iop=curr.left;
                while(iop.right!=null){
                    iop=iop.right;
                }
                iop.right=curr.right;
                ans.add(curr.val);
                curr=curr.left;
            }
            else{
                ans.add(curr.val);
                curr=curr.right;
                
            }
        }
        return ans;
    }
}


//Morris Traversal -->sir ka approach
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> retVal = new ArrayList<>();
        
//         TreeNode curr = root;
        
//         while(curr != null){
//             if(curr.left == null){
//                 retVal.add(curr.val);
//                 curr = curr.right;
//             } else {
//                 TreeNode iop = curr.left;
//                 while(iop.right != null && iop.right != curr){
//                     iop = iop.right;
//                 }
                
//                 if(iop.right == null){
//                     retVal.add(curr.val);
//                     iop.right = curr; // making the thread
//                     curr = curr.left;
//                 } else {
//                     iop.right = null;
                    
//                     curr = curr.right;
//                 }
//             }
//         }
        
//         return retVal;
//     }
// }
