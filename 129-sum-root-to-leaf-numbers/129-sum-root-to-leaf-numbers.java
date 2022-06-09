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
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> sumArray = new ArrayList<>();
        helper(root,0,sumArray);
        int ans=0;
        for(int i=0;i<sumArray.size();i++){
            ans+=sumArray.get(i);
        }
        return ans;
    }
    
    public void helper(TreeNode root,int num,ArrayList<Integer> sumArray){
        if(root.left!=null && root.right!=null){
            helper(root.left,(num*10)+root.val,sumArray);
            helper(root.right,(num*10)+root.val,sumArray);        }
        else if(root.left!=null){
            helper(root.left,(num*10)+root.val,sumArray);
        }
        else if(root.right!=null){
            helper(root.right,(num*10)+root.val,sumArray);  
        }
        else{
            sumArray.add((num*10)+root.val);
            return;
        }
    }
}