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
    public ListNode partition(ListNode head, int x) {
        ListNode curr1 = new ListNode(0);
        ListNode dummy1 = curr1;
        
        ListNode curr2 = new ListNode(0);
        ListNode dummy2 = curr2;
        
        while(head!=null){
            if(head.val<x){
                curr1.next = head;
                curr1 = head;
            }
            else{
                curr2.next = head;
                curr2 = head;
                
            }
            head = head.next;
        }
        
        curr2.next = null;
        curr1.next = dummy2.next;
        
        return dummy1.next;
    }
}