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
// Method 1
class Solution {
    int ans=1;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root,-10000);//I have taken parent initially less than -1000 -> given in constraints.
        return ans-1;
    }
    public int helper(TreeNode node,int p){
        if(node==null){
            return 0;
        }
        int lv=helper(node.left,node.val);
        int rv=helper(node.right,node.val);
        
        ans=Math.max(ans,rv+lv+1);
        if(node.val!=p){
            return 0;
        }
        else{
            return Math.max(lv,rv)+1;
        }
    }
}

//Method 2
// class Solution {
//     class pair{
//         TreeNode node;
//         int size=0;
        
//     }
//     static int ans=1;
//     public int longestUnivaluePath(TreeNode root) {
//         if(root==null){
//             return 0;
//         }
//         ans=1;
//         helper(root);
//         return ans-1;
        
        
        
//     }
//     public pair helper(TreeNode node){
//         if(node.left!=null && node.right!=null){
//             pair lp=helper(node.left);
//             pair rp=helper(node.right);
//             int ls=(lp.node.val==node.val) ? lp.size : 0;
//             int rs=(rp.node.val==node.val) ? rp.size : 0;
//             pair me =new pair();
//             ans=Math.max(ans,ls+rs+1);
//             me.size=Math.max(ls,rs)+1;
//             me.node=node;
//             return me;

//         }
//         else if(node.left!=null){
//             pair lp=helper(node.left);
            
//             int ls=(lp.node.val==node.val) ? lp.size : 0;
            
//             pair me =new pair();
//             ans=Math.max(ans,ls+1);
//             me.size=ls+1;
//             me.node=node;
//             return me;
//         }
//         else if(node.right!=null){
//             pair rp=helper(node.right);
            
//             int rs=(rp.node.val==node.val) ? rp.size : 0;
            
//             pair me =new pair();
//             ans=Math.max(ans,rs+1);
//             me.size=rs+1;
//             me.node=node;
//             return me;
//         }
//         else{
//             pair me=new pair();
//             me.node=node;
//             me.size=1;
//             return me;
//         }
//     }
    
 
// }