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
    // public TreeNode findNode(TreeNode root,int x){
    //     if(root==null){
    //         return null;
    //     }
    //     if(root.val==x){
    //         return root;
    //     }
    //     if(root.left!=null){
    //         TreeNode find=findNode(root.left,x);
    //         if(find!=null){
    //             return find;
    //         }
    //     }
    //     return findNode(root.right,x);
    // } 
    int xKaleft;
    int xKaright;
    public int size(TreeNode root,int x){
        if(root==null){
            return 0;
        }
        int leftlen=size(root.left,x);
        int rightlen=size(root.right,x);
        
        if(root.val==x){
            xKaleft=leftlen;
            xKaright=rightlen;
        }
        return leftlen+rightlen+1;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // TreeNode p1=findNode(root,x);
        
        // int totalSize=size(root);
        
        size(root,x);
        //int sizeleft=size(p1.left);
        //int sizeright=size(p1.right);
        
        // int sizeOfP1 =sizeleft+sizeright+1;
        int sizeOfP1=xKaleft+xKaright+1;
        // int remaining= totalSize-sizeOfP1;
         int remaining= n-sizeOfP1;
        int minrq=(n+1)/2;
        int p2=Math.max(remaining,Math.max(xKaleft,xKaright));
        if(p2>=minrq){
            return true;
        }
        else{
            return false;
        }
        
    }
}