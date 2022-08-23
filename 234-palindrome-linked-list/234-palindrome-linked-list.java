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
    public ListNode findMid(ListNode head){
        if(head==null){
            return null;
        }
        ListNode s=head;
        ListNode f=head;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode p=null;
        ListNode c=head;
        while(c!=null){
            ListNode f=c.next;
            c.next=p;
            p=c;
            c=f;
        }
        return p;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next== null){
            return true;
        }
        ListNode mid=findMid(head);
        ListNode nH=mid.next;
        mid.next=null;
        
        ListNode revH=reverse(nH);
        ListNode h1=revH;
        ListNode h2=head;
        while(h1!=null && h2!=null){
            if(h1.val!=h2.val){
                return false;
            }
            h1=h1.next;
            h2=h2.next;
            
        }
        return true;
    }
}