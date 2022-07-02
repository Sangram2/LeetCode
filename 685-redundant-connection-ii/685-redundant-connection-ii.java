class Solution {
    int[] dsu;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        boolean twoP = false;
        int[] e1 = null;
        int[] e2 = null;
        int[] parent = new int[n+1];
        Arrays.fill(parent,-1);
        
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            if(parent[to]==-1){
                parent[to] = from;
                
            }
            else{
                twoP = true;
                e2 = edge;
                e1 = new int[]{parent[to],to};
                break;
            }
        }
        
        dsu = new int[n+1];
        for(int i=0;i<=n;i++){
            dsu[i] = i;
        }
        
        if(!twoP){
            int[] res = null;
            for(int[] edge : edges){
                int from = edge[0];
                int to = edge[1];
                if(to == find(from)){
                    res = edge;
                    break;                  
                }
                else{
                    dsu[to] = find(from);
                }
            }
            return res;
            
        }
        else{
            boolean isCycle = false;
            for(int[] edge : edges){
                if(edge == e2){
                    continue;
                }
                int from = edge[0];
                int to = edge[1];
                if(to == find(from)){
                    isCycle = true;
                    break;                  
                }
                else{
                    dsu[to] = find(from);
                }
            }
            if(isCycle == true){
                return  e1;
            }
            else{
                return e2;
            }
        }
    }
    int find(int x){
        if(dsu[x] == x){
            return x;
        } 
        else{
            dsu[x] = find(dsu[x]);
            return dsu[x];
        }
    }
}