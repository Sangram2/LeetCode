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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int n = adj.size();
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        boolean[] ap = new boolean[n];
        
        
        for(int v = 0;v<n;v++){
            if(!vis[v]){
                dfs(v,-1,adj,vis,low,disc,ap);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(ap[i]){
                count++;
            }
        }
        if(count==0){
            return new int[]{-1};
        }
        int[] res = new int[count];
        int idx = 0;
        for(int i=0;i<n;i++){
            if(ap[i]){
                res[idx++] = i; 
            }
        }
        return res;
     }
     
     int time = 0;
     public void dfs(int u,int p,ArrayList<ArrayList<Integer>> adj, boolean[] vis,int[] low,int[] disc,boolean[] ap){
         vis[u] = true;
         disc[u] = low[u] = time++;
         int c = 0;
         for(int nbr : adj.get(u)){
             if(nbr==p){
                 continue;
             }
             else if(vis[nbr]){
                 low[u] = Math.min(disc[nbr],low[u]);
                 continue;
             }else{
                 c++;
                 dfs(nbr,u,adj,vis,low,disc,ap);
                 low[u] = Math.min(low[u],low[nbr]);
                 if(p != -1 && low[nbr]>=disc[u]){
                     ap[u] = true;
                 }
             }
             
         }
         if( p==-1 && c>1 ){
             ap[u]=true;
         }
     }
}