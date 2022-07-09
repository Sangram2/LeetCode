class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[src] = 0;
        for(int i=1;i<=k+1;i++){
            int[] dp = dist.clone();
            for(int[] edge : flights){
                int u = edge[0];
                int v = edge[1];
                int uv = edge[2];
                
                if(dist[u]!=Integer.MAX_VALUE){
                    dp[v] = Math.min(dp[v],dist[u]+uv);
                }
            }
            dist = dp;
        }
        
        if(dist[dst]!=Integer.MAX_VALUE){
            return dist[dst];
            
        }
        else{
            return -1;
        }
    }
}