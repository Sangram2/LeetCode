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
    int ans=0;
    class pair{
        int node;
        int coins;
        pair(){
            
        }
        pair(int node ,int coins){
            this.node=node;
            this.coins =coins;
        }
    }
    public int distributeCoins(TreeNode root) {
        helper(root);
        return ans;
    }
    public pair helper(TreeNode root){
        if(root==null){
            return new pair();
        }
        pair left=helper(root.left);
        pair right=helper(root.right);
        pair me=new pair();
        me.node=left.node+right.node+1;
        me.coins=root.val+left.coins+right.coins;
        ans+=Math.abs(me.node-me.coins);
        return me;
    }
}