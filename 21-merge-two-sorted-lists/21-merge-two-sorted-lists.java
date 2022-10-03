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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1==null ? l2:l1;
        }

        ListNode ans=new ListNode(-1);
        ListNode head=ans;
        ListNode one=l1;
        ListNode two=l2;

        while(one!=null && two!=null){
            if(one.val<=two.val){
                ans.next=one;
                ans=one;
                one=one.next;
            }
            else{
                ans.next=two;
                ans=two;
                two=two.next;
            }

        }
        if(one!=null){
            ans.next=one;
        }
        if(two!=null){
            ans.next=two;
        }
        
        return head.next;
    }
}