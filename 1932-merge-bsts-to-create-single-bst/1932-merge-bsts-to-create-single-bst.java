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
    public TreeNode canMerge(List<TreeNode> trees) {
        HashSet<Integer> leaves = new HashSet<>();
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        
        for(TreeNode tree:trees){
            hm.put(tree.val,tree);
            if(tree.left!=null){
                leaves.add(tree.left.val);
            }
            if(tree.right!=null){
                leaves.add(tree.right.val);
            }
            
        }
        
        TreeNode res = null;
        for(TreeNode tree:trees){
            if(!leaves.contains(tree.val)){
                res = tree;
                break;
            }
        }
        
        if(res == null){
            return null;
        }
        
        
        return traverse(res,Integer.MIN_VALUE,Integer.MAX_VALUE,hm) && hm.size()==1 ? res:null;
    
    }
    
    boolean traverse(TreeNode root,int min,int max,HashMap<Integer,TreeNode> hm){
        if(root==null){
            return true;
        }
        if(root.val>=max || root.val<=min){
            return false;
        }
        
        if(root.left==null && root.right==null){
            if(hm.containsKey(root.val) && root != hm.get(root.val)){
                TreeNode next = hm.get(root.val);
                root.left = next.left;
                root.right = next.right;
                hm.remove(root.val);
            }
        }
        
        return traverse(root.left,min,root.val,hm) && traverse(root.right,root.val,max,hm);
    }
}