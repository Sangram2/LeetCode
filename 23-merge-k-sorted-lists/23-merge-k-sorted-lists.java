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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k==0){
            return null;
        }
        boolean notfound = true;
        for(ListNode node:lists){
            if(node!=null){
                notfound = false;
            }
        }
        if(notfound){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        
        for(ListNode P : lists){
            if(P!=null)
                pq.add(P);
        }
       
        ListNode temp = null;
        ListNode head = null;
        while(pq.size()!=0){
            ListNode rem = pq.remove();
            
            if(head==null){
                head = rem;
                
            }
            if(temp!=null){
                temp.next = rem;
                temp = temp.next;
            }else{
                temp = head;
            }
            
            if(rem.next != null){
                pq.add(rem.next);
            }
            
        }
        
        
        return head;
        
    }
}