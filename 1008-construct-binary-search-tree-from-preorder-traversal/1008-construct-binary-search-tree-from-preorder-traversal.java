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
// class Solution {
//     static int idx=0;
//     public TreeNode bstFromPreorder(int[] preorder) {
//         idx=0;
//         TreeNode ans=construct(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
//         return ans;
        
//     }
//     public TreeNode construct(int[] preorder,Integer st,Integer en){
//         if(idx<preorder.length){
//             if(preorder[idx]<en && preorder[idx]>st){
//                 TreeNode root=new TreeNode(preorder[idx]);
//                 idx++;
//                 root.left= construct(preorder,st,root.val);
//                 root.right=construct(preorder,root.val,en);
//                 return root;
//             }
//             else{
//                 return null;
//             }

//         }
//         else{
//             return null;
//         }
//     }
// }
class Solution {
    static int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx=0;
        TreeNode ans=construct(preorder,Integer.MAX_VALUE);
        
        return ans;
        
    }
    public TreeNode construct(int[] preorder,Integer en){
        if(idx<preorder.length){
            if(preorder[idx]<en){
                TreeNode root=new TreeNode(preorder[idx]);
                idx++;
                root.left= construct(preorder,root.val);
                root.right=construct(preorder,en);
                return root;
            }
            else{
                return null;
            }

        }
        else{
            return null;
        }
    }
}