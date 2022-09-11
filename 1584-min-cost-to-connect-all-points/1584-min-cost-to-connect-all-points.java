class Solution {
class pp{
    int val;
    int pt;
    int wt;

    pp(){

    }
    pp(int val,int pt,int wt){
        this.val=val;
        this.pt=pt;
        this.wt=wt;
    }
}
class Edge {
  int src;
  int nbr;
  int wt;

  Edge(int src, int nbr, int wt) {
     this.src = src;
     this.nbr = nbr;
     this.wt = wt;
  }
}
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int dis = findDis(points[i],points[j]);
                graph[i].add(new Edge(i,j,dis));
                graph[j].add(new Edge(j,i,dis));
                
            }
        }
        
        int cost = 0;
        PriorityQueue<pp> pq=new PriorityQueue<>((a,b)->{
            return a.wt-b.wt;
        });
        boolean[] vis = new boolean[n];
        pq.add(new pp(0,-1,0));
        while(pq.size()>0){
            pp rem = pq.remove();
            if(vis[rem.val]){
                continue;
            }
            vis[rem.val] = true;
            cost += rem.wt;
            for(Edge p:graph[rem.val]){
                int nbr = p.nbr;
                if(!vis[nbr]){
                    pq.add(new pp(nbr,rem.val,p.wt));
                }
            }
            
        }
        return cost;
    }
    
    int findDis(int[] p1,int[] p2){
        return Math.abs(p1[1]-p2[1])+Math.abs(p1[0]-p2[0]);
    }
}