class Solution {
    
    int ans = -1;
    
    void dfs(int src,ArrayList<Integer> path,boolean[] vis,int[] edges){
        if(edges[src] == -1){
            return;
        }
        if(vis[src]){
            int count = -1;
            for(int i = 0;i<path.size();i++){
                if(path.get(i)==src){
                    count = i;
                    break;
                }
            }
            if(count == -1){
                return;
            }
            int size = path.size()-count;
            ans = Math.max(ans,size);
            return;
        }
        
        vis[src] = true;
        path.add(src);
        dfs(edges[src],path,vis,edges);
        
        
        
    }
    
    public int longestCycle(int[] edges) {
        boolean []vis = new boolean[edges.length];
        for(int i = 0;i<edges.length;i++){
            if(vis[i]==false){
                ArrayList<Integer> path = new ArrayList<>();
                dfs(i,path,vis,edges);
            }
        }
        return ans;
    }
}