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
    public TreeNode build(int[] postorder,int stp,int enp,int stIn,int enIn,HashMap<Integer,Integer> hm){
        if(stp==enp){
           return new TreeNode(postorder[stp]); 
        }
         if(stIn>enIn || stp>enp){
            return null;
        }
        TreeNode root=new TreeNode(postorder[enp]);
//         int mid=-1;
//         for(int i=stIn;i<=enIn;i++){
//             if(inorder[i]==postorder[stp]){
//                 mid=i;
                
//             }
//         }
        int mid=hm.get(postorder[enp]);
        int len = mid-stIn;
        if(mid==stIn){
            root.left=null;
        }else{
            root.left=build(postorder,stp,stp+len-1,stIn,mid-1,hm);
        }
        if(mid==enIn){
            root.right=null;
        }else{
            root.right=build(postorder,stp+len,enp-1,mid+1,enIn,hm);
        }
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length-1;
        if(n==0){
            return new TreeNode(inorder[0]);
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<=n;i++){
            hm.put(inorder[i],i);
        }
        return build(postorder,0,n,0,n,hm);
    }
}