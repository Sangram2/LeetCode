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
    
    public TreeNode construct(int []nums,int st,int en){
        if(st>en){
            return null;
        }
        if(st==en){
            return new TreeNode(nums[st]);
        }
        int mid=(st+en)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=construct(nums,st,mid-1);
        node.right=construct(nums,mid+1,en);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return construct(nums,0,nums.length-1);
    
    }
}