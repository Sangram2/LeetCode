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
    
//     static int count = 0;
    
//     public int findSize(TreeNode root){
//         if(root==null){
//             return 0;
//         }
//         int leftSize = findSize(root.left);
//         int rightSize = findSize(root.right);
//         return leftSize+rightSize+1;
//     }
    
//     public int findSum(TreeNode root){
//         if(root==null){
//             return 0;
//         }
//         int leftSum = findSum(root.left);
//         int rightSum = findSum(root.right);
//         return leftSum+rightSum+root.val;
//     }
//     public void findAns(TreeNode root){
//         if(root==null){
//             return;
//         }
        
//         int val = root.val;
//         int size = findSize(root);
//         int sum = findSum(root);
//         int avg = sum/size;
//         if(avg==val){
//             count++;
//         }
//         findAns(root.left);
//         findAns(root.right);
//     }
//     public int averageOfSubtree(TreeNode root){
//         count = 0; 
//         findAns(root);
//         return count;
//     }
    
    
    
    
    public class pair{
        int size;
        int sum;
        TreeNode node;
        
        pair(int size,int sum,TreeNode node){
            this.size = size;
            this.sum = sum;
            this.node = node;
        }
    }
        
    
    
    public pair helper(TreeNode root,ArrayList<pair> store){
        if(root==null){
            return new pair(0,0,null);
        }
        
        pair left = helper(root.left,store);
        pair right = helper(root.right,store);
        
        int MySize = left.size + right.size + 1;
        int MySum = left.sum + right.sum + root.val;
        
        store.add(new pair(MySize,MySum,root));
        
        return new pair(MySize,MySum,root);
    }
        
        
    public int averageOfSubtree(TreeNode root){
        ArrayList<pair> store = new ArrayList<>();
        helper(root,store);
        int ans=0;
        
        for(int i=0;i<store.size();i++){
            pair curr = store.get(i);
            int val = curr.node.val;
            int size = curr.size;
            int sum = curr.sum;
            int avg = sum/size;
            if(avg==val){
                ans++;
            }
        }
        return ans;
        
    }
}