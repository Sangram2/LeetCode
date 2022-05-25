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
    
    static int count = 0;
    
    public int findSize(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSize = findSize(root.left);
        int rightSize = findSize(root.right);
        return leftSize+rightSize+1;
    }
    
    public int findSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        return leftSum+rightSum+root.val;
    }
    public void findAns(TreeNode root){
        if(root==null){
            return;
        }
        
        int val = root.val;
        int size = findSize(root);
        int sum = findSum(root);
        int avg = sum/size;
        if(avg==val){
            count++;
        }
        findAns(root.left);
        findAns(root.right);
    }
    public int averageOfSubtree(TreeNode root){
        count = 0; 
        findAns(root);
        return count;
    }
}