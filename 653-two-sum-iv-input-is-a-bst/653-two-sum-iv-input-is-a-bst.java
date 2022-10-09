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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        dfs(root,inorder);
        int st = 0;
        int end = inorder.size()-1;
        while(st<end){
            int val = inorder.get(st)+inorder.get(end);
            if(val == k){
                return true;
            }
            else if(val>k){
                end--;
            }else{
                st++;
            }
        }
        return false;
        
        
    }
    
    public void dfs(TreeNode node,ArrayList<Integer> inorder){
        if(node == null){
            return;
        }
        dfs(node.left,inorder);
        inorder.add(node.val);
        dfs(node.right,inorder);
    }
}