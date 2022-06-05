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
    static int ans=0;
    public int minCameraCover(TreeNode root) {
        ans=0;
        //-1--->nm
        //0--->m
        //1--->c
        
        int check=solve(root);
        if(check==-1){
            return ans+1;
        }else{
            return ans;
        }
    }
    
    public int solve(TreeNode node){
        
        if(node==null){
            return 0;
        }
        int val1=solve(node.left);
        int val2=solve(node.right);
        if(val1==-1 || val2==-1){
            ans++;
            return 1;
        }
        else if(val1==1 || val2==1){
            return 0;
        }
        // else if(val1==0 && val2==0){
        //     return -1;
        // }
        else{
            return -1;
        }
        
    }
}
