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
    public class pair{
        int sum;
        int tilt;
        
        pair(){};
        pair(int sum,int tilt){
            this.sum=sum;
            this.tilt=tilt;
        }
    }
    
    public pair solve(TreeNode root){
        if(root==null){
            return new pair(0,0);
        }
        pair lp=solve(root.left);
        pair rp=solve(root.right);
        
        pair me=new pair();
        me.sum=lp.sum+rp.sum+root.val;
        me.tilt=Math.abs(lp.sum-rp.sum)+lp.tilt+rp.tilt;
        return me;
    }
    
    
    static int tilt=0;
    public int solve2(TreeNode root){
        if(root==null){
            return 0;
        }
        int ls=solve2(root.left);
        int rs=solve2(root.right);
        
       
        int sum=ls+rs+root.val;
        tilt+=Math.abs(ls-rs);
        return sum;
    }
    public int findTilt(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return 0;
        }
        // pair ans=solve(root);
        //return ans.tilt;
        tilt=0;
        solve2(root);
        return tilt;
        
    }
}