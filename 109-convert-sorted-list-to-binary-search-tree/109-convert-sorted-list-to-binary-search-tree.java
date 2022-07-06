/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        int[] arr = new int[size];
        int idx = 0;
        temp = head;
        while(temp!=null){
            arr[idx++] = temp.val;
            temp = temp.next;
        }
        TreeNode ans = solver(arr,0,size-1);
        return ans;
    }
    
    TreeNode solver(int[] arr,int st,int en){
        if(st>en){
            return null;
        }
        int mid = st+(en-st)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = solver(arr,st,mid-1);
        root.right = solver(arr,mid+1,en);
        return root;
    } 
}