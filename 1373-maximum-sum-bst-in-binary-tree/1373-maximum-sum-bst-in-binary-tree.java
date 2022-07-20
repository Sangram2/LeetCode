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
        int min;
        int max;
        int sum;
        boolean isBst;
        pair(){};
        pair(int min,int max,int sum,boolean isBst){
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBst = isBst;
        }
    }
    
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    pair dfs(TreeNode node){
        if(node==null){
            return new pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        }
        
        pair left = dfs(node.left);
        pair right = dfs(node.right);
        
        
        
        if(left.isBst && right.isBst){
           if(node.val>left.max && node.val<right.min){
               pair myPair = new pair();
               myPair.sum = left.sum+right.sum+node.val;
               ans = Math.max(ans,myPair.sum);
               myPair.min = (left.min!=Integer.MAX_VALUE) ? left.min : node.val;
               myPair.max = (right.max!=Integer.MIN_VALUE) ? right.max : node.val;
               myPair.isBst = true;
               return myPair;
           } else{
                return new pair(Integer.MIN_VALUE,Integer.MAX_VALUE,0,false);
           }
        }
        else{
            return new pair(Integer.MIN_VALUE,Integer.MAX_VALUE,0,false);
        }
        
        
    }
}