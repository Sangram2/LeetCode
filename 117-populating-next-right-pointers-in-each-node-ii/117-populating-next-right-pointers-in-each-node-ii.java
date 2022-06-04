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

// class Solution {
//     public Node connect(Node root) {
        
//     }
// }

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        
        Queue<Node> qu=new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while(qu.size()!=0){
            Node rem=qu.remove();
            if(rem!=null){
                rem.next=qu.peek();
                if(rem.left!=null){
                    qu.add(rem.left);
                }  
                if(rem.right!=null){
                    qu.add(rem.right);
                }
            }
                
            
            else if(rem==null && qu.size()!=0){
                qu.add(null);
            }
        }
        return root;
    }
}