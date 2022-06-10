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
        int idx;
        pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int width=helper(root);
        return width;
    }
    public int helper(TreeNode root){
        int ans=0;
        Queue<pair> qu = new LinkedList<>();
        qu.add(new pair(root,0));
        
        while(qu.size()!=0){
            int left=-1,right=-1;
            int size = qu.size();
            for(int i=0;i<size;i++){
                pair rem=qu.remove();
                if(i==0){
                    left=rem.idx;
                }
                if(i==size-1){
                    right=rem.idx;
                }
                if(rem.node.left!=null){
                    qu.add(new pair(rem.node.left,(rem.idx*2)+1));
                }
                if(rem.node.right!=null){
                    qu.add(new pair(rem.node.right,(rem.idx*2)+2));
                }
            }
            ans=Math.max(ans,right-left+1);
        }
        
        return ans;
    }
}