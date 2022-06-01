// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution g = new Solution();

                System.out.println(g.maxPathSum(root));
        	
                t--;   
        }
    }
}


// } Driver Code Ends


//User function Template for Java
//Method 1
// class Solution
// {   
//     static int ans=Integer.MIN_VALUE;

//     public static void findLtoRoot(Node node,int sum){
//         if(node.left==null && node.right==null){
//             int pans=sum+node.data;
//             if(pans>ans){
//                 ans=pans;
//             }
//         }
//         else{
//             int new_sum=sum+node.data;
//             if(node.left!=null)
//                 findLtoRoot(node.left,new_sum);
//             if(node.right!=null)    
//                 findLtoRoot(node.right,new_sum);
//         }
        
//     }
    
    
//     public static int maxPathSum(Node root)
//     {
//         ans=Integer.MIN_VALUE;
//         findLtoRoot(root,0);
//         return ans;
//     }
// }



//Method 2
// class Solution
// {   

    
    
    
//     public static int maxPathSum(Node root)
//     {
//         if(root.left==null && root.right==null){
//             return root.data;
//         }
//         int leftSum=Integer.MIN_VALUE;
//         int rightSum=Integer.MIN_VALUE;
//         if(root.left!=null)
//             leftSum=maxPathSum(root.left);
//         if(root.right!=null)
//             rightSum=maxPathSum(root.right);
//         return Math.max(leftSum,rightSum)+root.data;
        
//     }
// }


//Method 3
class Solution
{
    public static int maxPathSum(Node root)
    {
        if(root.left != null && root.right != null){
            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);
            return Math.max(left, right) + root.data;
        } else if(root.left != null){
            int left = maxPathSum(root.left);
            return left + root.data;
        } else if(root.right != null){
            int right = maxPathSum(root.right);
            return right + root.data;            
        } else {
            // leaf
            return root.data;
        }
    }
}


