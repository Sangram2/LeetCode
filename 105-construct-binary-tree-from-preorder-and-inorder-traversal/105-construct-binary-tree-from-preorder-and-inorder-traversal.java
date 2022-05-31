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
    
    public TreeNode build(int[] preorder, int[] inorder,int stp,int enp,int stIn,int enIn){
        if(stIn==enIn){
           return new TreeNode(inorder[stIn]); 
        }
        // else if(stIn>enIn){
        //     return null;
        // }
        TreeNode root=new TreeNode(preorder[stp]);
        int mid=-1;
        for(int i=stIn;i<=enIn;i++){
            if(inorder[i]==preorder[stp]){
                mid=i;
                
            }
        }
        int len = mid-stIn;
        if(mid==stIn){
            root.left=null;
        }else{
            root.left=build(preorder,inorder,stp+1,stp+len,stIn,mid-1);
        }
        if(mid==enIn){
            root.right=null;
        }else{
            root.right=build(preorder,inorder,stp+len+1,enp,mid+1,enIn);
        }
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        
        int n=preorder.length-1;
        if(n==0){
            return new TreeNode(inorder[0]);
        }
        
        return build(preorder,inorder,0,n,0,n);
    }
}