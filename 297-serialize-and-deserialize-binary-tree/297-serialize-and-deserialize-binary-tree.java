/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        helper(root,sb);
        return sb.toString();
        
    }
    void helper(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append(".");
            sb.append(" ");
            return;
        }
        sb.append(node.val);
        sb.append(" ");
        
        helper(node.left,sb);
        helper(node.right,sb);
    }
    class pair {
        TreeNode node;
        int state=0; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        
        String[] darray=data.split(" ");
        Stack<pair> st= new Stack<>();
        pair rootp=new pair();
        rootp.node=new TreeNode(Integer.parseInt(darray[0]));
        
        st.push(rootp);
        int idx=0;
        
        while(st.size()>0){
            pair rem=st.peek();
            
            if(rem.state==0){
                idx++;
                rem.state++;
                if(darray[idx].equals(".")==false){
                    pair leftp=new pair();
                    leftp.node=new TreeNode(Integer.parseInt(darray[idx]));
                    rem.node.left=leftp.node;
                    st.push(leftp);
                }
               
                

            }
            
            
            else if(rem.state == 1){
                idx++;
                rem.state++;
                if(darray[idx].equals(".")==false){
                    pair rightp=new pair();
                    rightp.node=new TreeNode(Integer.parseInt(darray[idx]));
                    rem.node.right=rightp.node;
                    st.push(rightp);
                }
                
            }
            
            
            else if(rem.state==2){
                st.pop();
            }

        }
        
        return rootp.node;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));