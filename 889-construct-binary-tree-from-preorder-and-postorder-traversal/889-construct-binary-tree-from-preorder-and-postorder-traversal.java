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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            hm.put(postorder[i],i);
        }
        TreeNode ans=helper(hm,preorder,postorder,0,preorder.length-1,0,postorder.length-1);
        return ans;
    }
    public TreeNode helper(HashMap<Integer,Integer> hm,int[] pre, int[] post,int spre,int epre,int spo,int epo){
        if(spre>epre || spo>epo){  //This case will never generate if the tree is full
            return null;
        }
        
        if(spre==epre || spo==epo){
            return new TreeNode(pre[spre]);
        }
        TreeNode root=new TreeNode(pre[spre]);
        if(spre+1<=epre){  //you can revove this if statement and write every thing outside the if block if the treee is full.
            
            int idx = hm.get(pre[spre+1]);
            int len=idx-spo+1;
        
            root.left=helper(hm,pre,post,spre+1,spre+len,spo,idx);
            root.right=helper(hm,pre,post,spre+len+1,epre,idx+1,epo-1);
        }
        return root;
    }
}