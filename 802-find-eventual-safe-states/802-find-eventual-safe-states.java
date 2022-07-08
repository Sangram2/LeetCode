class Solution {
    int[] vis;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        vis = new int[graph.length];
        for(int v=0;v<graph.length;v++){
            boolean isSafe = dfs(graph,v);
            if(isSafe){
                ans.add(v);
            }
        }
        return ans;
    }
    
    boolean dfs(int[][] graph,int i){
        if(vis[i]==2){
            return true;
        }
        if(vis[i]==1){
            return false;
            
        }
        vis[i] = 1;
        for(int nbr : graph[i]){
            boolean c = dfs(graph,nbr);
            if(c==false){
                return false;
            }
        } 
        vis[i] = 2;
        return true;
    }
}