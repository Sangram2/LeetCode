class Solution {
    public class pair{
        int val;
        int color;
        pair(){};
        pair(int val,int color){
            this.val=val;
            this.color=color; //0-->red <--> 1-->blue 
        }
    }
    public boolean solve(int[][] graph,int []vis,int src){
        Queue<pair> qu=new LinkedList<>();
        if(vis[src]==-1){
            qu.add(new pair(src,0));
        }
        while(qu.size()!=0){
            pair rem=qu.remove();
            if(vis[rem.val]!=-1){
                if(rem.color==vis[rem.val]){
                    continue;
                }
                else{
                    return false;
                }
            }
            vis[rem.val]=rem.color;
            for(int nbr : graph[rem.val]){
                if(vis[nbr]==-1){
                    if(rem.color==0){
                        qu.add(new pair(nbr,1));
                    }
                    else{
                        qu.add(new pair(nbr,0));
                    }
                }
            }
            
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []vis=new int[n];
        
        Arrays.fill(vis,-1);
        // for(int i=0;i<n;i++){
        //     vis[i]=-1;
        // }
        
        for(int i=0;i<n;i++){
            boolean ans=solve(graph,vis,i);
            if(ans==false){
                return false;
            }
        }
        return true;
        
        
            
        
            
    }
}