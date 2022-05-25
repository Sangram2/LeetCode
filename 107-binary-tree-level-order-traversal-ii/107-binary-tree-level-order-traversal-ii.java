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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            List<List<Integer>> ans = new ArrayList<>();
            return ans;
        }
        
        List<List<Integer>> ans1 = new ArrayList<>();
        Stack<List<Integer>> st = new Stack<>();
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> curr = new ArrayList<>();
        qu.add(root);
        qu.add(null);
        while(qu.size()!=0){
            TreeNode rem = qu.remove();
            if(rem!=null){
                curr.add(rem.val);
                if(rem.left!=null){
                    qu.add(rem.left);
                }
                if(rem.right!=null){
                    qu.add(rem.right);
                }
            }
            else{
                st.push(curr);
                curr = new ArrayList<>();
                if(qu.size()>0){
                    qu.add(rem);
                }
            }
            
            
        }
        while(st.size()!=0){
            List<Integer> part = st.pop();
            ans1.add(part);
        }
        
        
        return ans1;
        
    }
}