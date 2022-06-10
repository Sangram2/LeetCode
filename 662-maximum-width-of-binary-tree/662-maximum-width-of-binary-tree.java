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
// class Solution {
//     class pair{
//         TreeNode node;
//         int idx;
//         pair(TreeNode node,int idx){
//             this.node=node;
//             this.idx=idx;
//         }
//     }
//     public int widthOfBinaryTree(TreeNode root) {
//         int width=helper(root);
//         return width;
//     }
//     public int helper(TreeNode root){
//         int ans=0;
//         Queue<pair> qu = new LinkedList<>();
//         qu.add(new pair(root,0));
        
//         while(qu.size()!=0){
//             int left=-1,right=-1;
//             int size = qu.size();
//             for(int i=0;i<size;i++){
//                 pair rem=qu.remove();
//                 if(i==0){
//                     left=rem.idx;
//                 }
//                 if(i==size-1){
//                     right=rem.idx;
//                 }
//                 if(rem.node.left!=null){
//                     qu.add(new pair(rem.node.left,(rem.idx*2)+1));
//                 }
//                 if(rem.node.right!=null){
//                     qu.add(new pair(rem.node.right,(rem.idx*2)+2));
//                 }
//             }
//             ans=Math.max(ans,right-left+1);
//         }
        
//         return ans;
//     }
// }

// Method 2
class Solution {
    class Pair {
        long min;
        long max;
    }
    
    long maxW = 0;
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Pair> map = new HashMap<>();
        maxW = 0;
        helper(root, 1, 1, map);
        return (int)maxW;
    }
    
    public void helper(TreeNode node, int level, long idx, HashMap<Integer, Pair> map){
        if(node == null){
            return;
        }
        
        helper(node.left, level + 1, 2 * idx, map);
        helper(node.right, level + 1, 2 * idx + 1, map);
        
        Pair p = null;
        
        if(map.containsKey(level)){
            p = map.get(level);
            p.max = idx;
        } else {
            p = new Pair();
            p.min = idx;
            p.max = idx;
            map.put(level, p);
        }
        
        long width = p.max - p.min + 1;
        if(width > maxW){
            maxW = width;
        }
    }
    
    
    
}