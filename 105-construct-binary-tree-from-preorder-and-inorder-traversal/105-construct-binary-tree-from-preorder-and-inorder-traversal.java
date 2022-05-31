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
    
    public TreeNode build(int[] preorder, int[] inorder,int stp,int enp,int stIn,int enIn,HashMap<Integer,Integer> hm){
        if(stIn==enIn){
           return new TreeNode(inorder[stIn]); 
        }
        else if(stIn>enIn){
            return null;
        }
        TreeNode root=new TreeNode(preorder[stp]);
//         int mid=-1;
//         for(int i=stIn;i<=enIn;i++){
//             if(inorder[i]==preorder[stp]){
//                 mid=i;
                
//             }
//         }
        int mid=hm.get(preorder[stp]);
        int len = mid-stIn;
        if(mid==stIn){
            root.left=null;
        }else{
            root.left=build(preorder,inorder,stp+1,stp+len,stIn,mid-1,hm);
        }
        if(mid==enIn){
            root.right=null;
        }else{
            root.right=build(preorder,inorder,stp+len+1,enp,mid+1,enIn,hm);
        }
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        
        int n=preorder.length-1;
        if(n==0){
            return new TreeNode(inorder[0]);
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<=n;i++){
            hm.put(inorder[i],i);
        }
        return build(preorder,inorder,0,n,0,n,hm);
    }
}