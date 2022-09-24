class Solution {
    int[] rank;
    int[] parent;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        rank = new int[n];
        parent = new int[n];
        
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[] edge:edges){
            int l1 = edge[0];
            int l2 = edge[1];
            if(find(l1) != find(l2)){
                System.out.println(l1+" "+l2);
                union(l1,l2);
            }
        }
        // for(int i = 0;i<n;i++){
        //     System.out.print(parent[i]+" ");
        // }
        return find(source) == find(destination);
        
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    void union(int x,int y){
        x = find(x);
        y = find(y);
        if(rank[x]>rank[y]){
            parent[y] = x;
        }
        else if(rank[y]>rank[x]){
            parent[x] = y;
        }else{
            parent[x] = y;
            rank[y]++;
        }
    }
}