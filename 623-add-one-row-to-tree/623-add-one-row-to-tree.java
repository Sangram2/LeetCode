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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        
        dfs(root,1,depth,val);
        return root;
    }
    
    void dfs(TreeNode node,int cd,int depth,int val){
        if(node == null){
            return;
        }
        if(cd == depth-1){
            TreeNode l = null;
            if(node.left!=null){
                l = node.left;
                
            }
            TreeNode k1 = new TreeNode(val);
            node.left = k1;
            k1.left = l;
            
            TreeNode r = null;
            
            if(node.right!=null){
                r = node.right;
                
            }
            TreeNode k2 = new TreeNode(val);
            node.right = k2;
            k2.right = r;
        }
        dfs(node.left,cd+1,depth,val);
        dfs(node.right,cd+1,depth,val);
        
    }
}