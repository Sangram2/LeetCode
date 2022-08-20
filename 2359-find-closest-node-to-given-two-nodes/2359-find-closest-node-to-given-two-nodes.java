class Solution {
    
    void bfs(int src,int[] e,int[] dis){
        Queue<Integer> qu = new LinkedList<>();
        dis[src] = 0;
        qu.add(src);
        int d = 1;
        while(qu.size()!=0){
            int rem = qu.remove();
            if(e[rem]!=-1 && dis[e[rem]]==Integer.MAX_VALUE){
                qu.add(e[rem]);
                dis[e[rem]] = d;
                d++;
            }
            
        }
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dis1 = new int[n];
        int[] dis2 = new int[n];
        Arrays.fill(dis1,Integer.MAX_VALUE);
        Arrays.fill(dis2,Integer.MAX_VALUE);
        
        bfs(node1,edges,dis1);
        bfs(node2,edges,dis2);
        
        int res = Integer.MAX_VALUE,node = -1;
        for(int i=0;i<n;i++){
            int d1 = dis1[i];
            int d2 = dis2[i];
            
            if(d1==Integer.MAX_VALUE || d2 == Integer.MAX_VALUE){
                continue;
            }
            
            if(res>Math.max(d1,d2)){
                res = Math.max(d1,d2);
                node = i;
            }
        }
        return node;
    }
}