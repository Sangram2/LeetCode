/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public int size(ListNode node){
        int count =0;
        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }
    public ListNode detectCycle(ListNode head){
        if(head==null || head.next==null){
            return null;
        }
        ListNode s=head;
        ListNode f=head;
        boolean isCP=false;
        
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){
                isCP=true;
                break;
            }
        }
        if(!isCP){
            return null;
        }
        f=head;
        while(f!=s){
            f=f.next;
            s=s.next;
        }
        return f;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Method 1
//         if(headA==null || headB==null){
//             return null;
//         }
        
//         int sizeA=size(headA);
//         int sizeB=size(headB);
//         int d;
//         ListNode ptr1;
//         ListNode ptr2;
        
//         if(sizeA>sizeB){
//             d=sizeA-sizeB;
//             ptr1=headA;
//             ptr2=headB;
//         }
//         else{
//             d=sizeB-sizeA;
//             ptr1=headB;
//             ptr2=headA;
//         }
//         for(int i=0;i<d;i++){
//             ptr1=ptr1.next;
//         }
//         while(ptr1!=ptr2){
//             ptr1=ptr1.next;
//             ptr2=ptr2.next;
//         }
//         return ptr1;
        
        //Method 2
        if(headA==null || headB==null){
            return null;
        }
        
        ListNode tail=headA;
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=headB;
        ListNode ans=detectCycle(headA);
        tail.next=null;
        return ans;
        
        
    }
}