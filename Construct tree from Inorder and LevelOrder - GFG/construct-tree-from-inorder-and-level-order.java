// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<level.length;i++){
            hm.put(level[i],i);
        }
        return helper(hm,inord,0,inord.length-1);
    }
    Node helper(HashMap<Integer,Integer> hm,int inord[],int si,int ei){
        if(si>ei){
            return null;
        }
        
        int min=Integer.MAX_VALUE,idx=-1;
        for(int i=si;i<=ei;i++){
            int temp = hm.get(inord[i]);
            if(temp<min){
                idx=i;
                min=temp;
            }
        }
        Node root=new Node(inord[idx]);
        root.left=helper(hm,inord,si,idx-1);
        root.right=helper(hm,inord,idx+1,ei);
        return root;
        
    }
    
   
}


