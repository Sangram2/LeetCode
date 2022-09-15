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
    public ListNode reverseList(ListNode head) {
        if(head==null)
        return null;

        else{
            ListNode p=null;
            ListNode curr=head;

            while(curr!=null){
                ListNode f=curr.next;
                curr.next=p;
                p=curr;
                curr=f;

            }
            return p;

        }
    }
}