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
 public class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if(root==null) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(root, sum, res, path);
            return res;
        }
        
        public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
            
            path.add(root.val);
            
            if(root.left==null && root.right==null ){
                if(root.val==sum){
                    res.add(new ArrayList<Integer>(path));
                    
                }
                path.remove(path.size()-1);
                return;
            }
            if(root.left!=null) {
                dfs(root.left,sum-root.val,res,path);
                
            }
            if(root.right!=null) {
                dfs(root.right,sum-root.val,res,path);
                
            }
            path.remove(path.size()-1);
            
        }
    }