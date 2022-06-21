// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Stack<Integer> st = new Stack<>();
        int []vis = new int[V];
        for(int v=0;v<V;v++){
            if(vis[v]==0){
                dfs(adj,st,vis,v);
            }
        }
        int pmv = st.pop();
        dfs2(adj,vis,pmv);
        
        boolean av = true;
        
        for(int g : vis){
            if(g==1){
                av=false;
            }
        }
        
        if(av){
            return pmv;
        }
        else{
            return -1;
        }
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>adj,Stack<Integer> st,int[] vis,int v){
        vis[v]=1;
        for(int nbr : adj.get(v)){
            if(vis[nbr]==0){
                dfs(adj,st,vis,nbr);
            }
        }
        st.push(v);
    }
    public void dfs2(ArrayList<ArrayList<Integer>>adj,int[] vis,int v){
        vis[v]=2;
        for(int nbr : adj.get(v)){
            if(vis[nbr]==1){
                dfs2(adj,vis,nbr);
            }
        }
        
    }
    
    
}