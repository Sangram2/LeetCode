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
    class pair{
        TreeNode node;
        int size=0;
        
    }
    static int ans=1;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        ans=1;
        helper(root);
        return ans-1;
        
        
        
    }
    public pair helper(TreeNode node){
        if(node.left!=null && node.right!=null){
            pair lp=helper(node.left);
            pair rp=helper(node.right);
            int ls=(lp.node.val==node.val) ? lp.size : 0;
            int rs=(rp.node.val==node.val) ? rp.size : 0;
            pair me =new pair();
            ans=Math.max(ans,ls+rs+1);
            me.size=Math.max(ls,rs)+1;
            me.node=node;
            return me;

        }
        else if(node.left!=null){
            pair lp=helper(node.left);
            
            int ls=(lp.node.val==node.val) ? lp.size : 0;
            
            pair me =new pair();
            ans=Math.max(ans,ls+1);
            me.size=ls+1;
            me.node=node;
            return me;
        }
        else if(node.right!=null){
            pair rp=helper(node.right);
            
            int rs=(rp.node.val==node.val) ? rp.size : 0;
            
            pair me =new pair();
            ans=Math.max(ans,rs+1);
            me.size=rs+1;
            me.node=node;
            return me;
        }
        else{
            pair me=new pair();
            me.node=node;
            me.size=1;
            return me;
        }
    }
    
 
}