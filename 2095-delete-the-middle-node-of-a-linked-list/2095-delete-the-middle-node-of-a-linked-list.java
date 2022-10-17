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
class Solution {
    
    public int length(ListNode head){
        int len = 0;
        ListNode t = head;
        while(t!=null){
            len++;
            t = t.next;
        }
        return len;
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }
        int len = length(head);
        int mid = len/2;
        int idx = 0;
        ListNode temp = head;
        
        while(idx<mid-1){
           temp = temp.next;
           idx++; 
        }
        ListNode li = temp.next;
        
        temp.next = temp.next.next;
        li.next = null;
        return head;
    }
}