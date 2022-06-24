// class Solution {
//     int[] rank;
//     int[] parent;
//     public int[] findRedundantConnection(int[][] edges) {
//         int n =edges.length;
//         rank = new int[n+1];
//         parent = new int[n+1];
        
//         for(int i=0;i<n+1;i++){
//             parent[i]=i;
//             rank[i]=0;
//         }
        
//         for(int[] edge : edges){
//             int srcL = find(edge[0]);
//             int nbrL = find(edge[1]);
            
//             if(srcL==nbrL){
//                 return edge;
//             }
//             else{
//                 union(srcL,nbrL);
//             }
//         }
//         return new int[]{};
//     }
    
//     public int find(int x){
//         if(parent[x]==x){
//             return x;
//         }
//         else{
//             parent[x] = find(parent[x]);
//             return parent[x];
//         }
//     }
//     public void union(int sl1,int sl2){
//         if(rank[sl1]<rank[sl2]){
//             parent[sl1] = sl2;
//         }
//         else if(rank[sl1]>rank[sl2]){
//             parent[sl2] = sl1;
//         }
//         else{
//             parent[sl2]=sl1;
//             rank[sl1]++;
//         }
//     }
// }

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[] e: edges){
            int xl = find(e[0]);
            int yl = find(e[1]);
            
            if(xl != yl){
                union(xl, yl);
            } else {
                return e;
            }
        }
        
        return null;
    }
    
    int[] parent;
    int[] rank;
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int xl, int yl){
        if(rank[xl] < rank[yl]){
            parent[xl] = yl;
        } else if(rank[yl] < rank[xl]){
            parent[yl] = xl;
        } else {
            parent[xl] = yl;
            rank[yl]++;
        }
    }
}