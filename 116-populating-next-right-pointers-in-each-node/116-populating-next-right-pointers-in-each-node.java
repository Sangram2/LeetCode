/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node curr=root;
        while(curr.left!=null){
            Node lt=curr;
            while(lt!=null){
                lt.left.next=lt.right;
                if(lt.next!=null){
                    lt.right.next=lt.next.left;
                }
                lt=lt.next;
            }
            curr=curr.left;
        }
        return root;
    }
}