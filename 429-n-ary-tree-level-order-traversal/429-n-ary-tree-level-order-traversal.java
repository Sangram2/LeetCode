/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while(qu.size()!=0){
            int size = qu.size();
            List<Integer> level = new ArrayList<>();
            while((size--)>0){
                Node rem = qu.remove();
                level.add(rem.val);
                for(Node child : rem.children){
                    if(child!=null){
                        qu.add(child);
                    }
                }
                
            }
            res.add(level);
        }
        return res;
    }
}