/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair{
        TreeNode node;
        String dir="";
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<pair> stPath = nodeToRoot(root,startValue,"");
        ArrayList<pair> destPath=nodeToRoot(root,destValue,"");
        int i=stPath.size()-1,j=destPath.size()-1;
        StringBuilder ans=new StringBuilder("");
        while(i>=0 && j>=0 && stPath.get(i).node==destPath.get(j).node){
            i--;
            j--;
        }
        for(int h=0;h<=i;h++){
            ans.append("U");
        }
        for(int k=j;k>=0;k--){
            ans.append(destPath.get(k).dir);
        }
        return ans.toString();
        
    }
    
    public ArrayList<pair> nodeToRoot(TreeNode root,int data,String dir){
        if(root==null){
            return new ArrayList<>();
        }
        if(root.val==data){
            ArrayList<pair> me = new ArrayList<>();
            pair d=new pair();
            d.node=root;
            d.dir=dir;
            me.add(d);
            return me;
        }
        ArrayList<pair> left=nodeToRoot(root.left,data,"L");
        if(left.size()!=0){
            pair d=new pair();
            d.node=root;
            d.dir=dir;
            left.add(d);
            return left;
        }
        ArrayList<pair> right=nodeToRoot(root.right,data,"R");
        if(right.size()!=0){
            pair d=new pair();
            d.node=root;
            d.dir=dir;
            right.add(d);
            return right;
        }
        return new ArrayList<>();
    }
    
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                   