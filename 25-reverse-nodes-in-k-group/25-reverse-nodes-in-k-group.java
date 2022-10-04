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
    public ListNode th=null,tt=null;
    
    public int calSize(ListNode temp){
        
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public void addFirst(ListNode node){
        if(node==null){
            return;
        }
        if(th==null){
            th=tt=node;
            
        }
        else{
            node.next=th;
            th=node;
        }
        
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        } 
        int size=calSize(head);
        ListNode oh=null;
        ListNode ot=null;
        ListNode curr=head;
        
        while(size>=k){
            
            //Making the temporary reversed group.
            for(int i=0;i<k;i++){
                ListNode f=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=f;
            }
            
            //adding it to our original list according to condition 
            if(oh==null){
                oh=th;
                ot=tt;
            }
            else{
                ot.next=th;
                ot=tt;
            }
            
            
            th=null;
            tt=null;
            
            size-=k;
            
        }
        ot.next=curr;
        return oh;
        
    }
}