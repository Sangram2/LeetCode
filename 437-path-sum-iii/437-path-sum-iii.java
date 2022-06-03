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

//Method 2
class Solution {
    static int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        ans=0;
        countPath(root,hm,0,targetSum);
        return ans;
    }
    public void countPath(TreeNode node,HashMap<Integer,Integer> hm,int sum,int target){
        if(node==null){
            return;
        }
        sum+=node.val;
        
        if(hm.containsKey(sum-target)){
            ans+=hm.get(sum-target);
        }
        hm.put(sum,hm.getOrDefault(sum,0)+1);
        countPath(node.left,hm,sum,target);
        countPath(node.right,hm,sum,target);
        
        
        if(hm.get(sum)-1==0){
            hm.remove(sum);
        }
        else{
            hm.put(sum,hm.get(sum)-1);
        }
        
        
    }
}


//Method 2
// class Solution {
//     int count = 0;
//     public int pathSum(TreeNode root, int targetSum) {
        
//         travel1(root,targetSum);
        
        
        
//         return count;
//     }
    
//     public void travel1(TreeNode node,int target){
//         if(node == null){
//             return;
//         }
        
//         travel2(node,0,target);
//         travel1(node.left,target);
//         travel1(node.right,target);
//     }
    
//     public void travel2(TreeNode node, int csum, int targetSum){
//         if(node == null){
//             return;
//         }
//         if(csum + node.val == targetSum){
//             count++;
//         }
        
//         travel2(node.left, csum + node.val, targetSum);
//         travel2(node.right, csum + node.val, targetSum);
//     }
// }