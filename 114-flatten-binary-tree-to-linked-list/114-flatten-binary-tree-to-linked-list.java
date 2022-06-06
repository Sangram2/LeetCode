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
//     public void flatten(TreeNode root) {
//         if(root==null)
//             return;
        
//         TreeNode l=helper(root.left);
//         TreeNode r=helper(root.right);
//         if(l!=null){
//             TreeNode temp=l;
        
//             while(temp.right!=null){
//                 temp=temp.right;
//             }
//             temp.right=r;
//         }else{
//             l=r;
//         }
        
//         root.right=null;
//         root.left=null;
//         root.right=l;
        
//     }
//     public TreeNode helper(TreeNode root){
//         if(root==null){
//             return null;
//         }
        
//         TreeNode node=new TreeNode(root.val);
        
//         node.right=helper(root.left);
//         TreeNode temp=node;
//         while(temp.right!=null){
//             temp=temp.right;
//         }
//         temp.right=helper(root.right);
//         return node;
       
//     }
// }

// Method 2
// class Solution {
//     class Pair {
//         TreeNode head;
//         TreeNode tail;

//         Pair(){

//         }

//         Pair(TreeNode head, TreeNode tail){
//             this.head = head;
//             this.tail = tail;
//         }
//     }

//     public void flatten(TreeNode root) {
//         if(root != null){
//             helper(root);
//         }
//     }

//     public Pair helper(TreeNode node){
//         if(node.left != null && node.right != null){
//             Pair lp = helper(node.left);
//             Pair rp = helper(node.right);

//             Pair mp = new Pair();

//             mp.head = node;
//             mp.head.left = null;
//             mp.head.right = lp.head;
//             lp.tail.right = rp.head;
//             mp.tail = rp.tail;

//             return mp;
//         } else if(node.left != null){
//             Pair lp = helper(node.left);

//             Pair mp = new Pair();

//             mp.head = node;
//             mp.head.left = null;
//             mp.head.right = lp.head;
//             mp.tail = lp.tail;

//             return mp;
//         } else if(node.right != null){
//             Pair rp = helper(node.right);

//             Pair mp = new Pair();

//             mp.head = node;
//             mp.head.left = null;
//             mp.head.right = rp.head;
//             mp.tail = rp.tail;

//             return mp;
//         } else {
//             Pair mp = new Pair(node, node);
//             return mp;
//         }
//     }

// }


class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        
        root.right=prev;
        root.left=null;
        prev=root;
    }
}