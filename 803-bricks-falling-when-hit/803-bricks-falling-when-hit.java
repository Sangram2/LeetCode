class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int[] parent;
    int[] rank;
    int[] size;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        
        parent = new int[m*n+1];
        rank = new int[m*n+1];
        size = new int[m*n+1];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int[] hit:hits){
            int i=hit[0];
            int j = hit[1];
            if(grid[i][j] == 1){
                grid[i][j] = 2;
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(grid[i][j] == 1){
    
                        handleUnion(grid,i,j);
                   
                }
            }
        }
        int[] res = new int[hits.length];
        int idx = hits.length-1;
        
        for(int k=hits.length-1;k>=0;k--){
            int i = hits[k][0];
            int j = hits[k][1];
            
            if(grid[i][j]==2){
                grid[i][j] = 1;
                int Size =size[find(0)];
                handleUnion(grid,i,j);
                int nSize = size[find(0)];
                
                if(nSize>Size){
                    res[idx] = nSize-Size-1; 
                }
                
                
                
            }
            idx--;
        }
        return res;
        
        
        
    }
    
    
    void handleUnion(int[][]grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        for(int[]d:dir){
            int r = i+d[0];
            int c = j+d[1];

            if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1){
                int nBoxNo = (r*n)+c+1;
                int boxNo = ((i*n)+j)+1;

                if(find(nBoxNo)!=find(boxNo)){
                    union(find(nBoxNo),find(boxNo));
                }
            }
        }
        if(i==0){
            int boxNo = ((i*n)+j)+1;
            if(find(0)!=find(boxNo))
                union(find(0),find(boxNo));
        }
    }
        
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    void union(int x,int y){
        if(rank[x]>rank[y]){
            parent[y] = x;
            size[x] += size[y];
            
        }
        else if(rank[x]<rank[y]){
            parent[x] = y;
            size[y] += size[x];
        }
        else{
            parent[x] = y;
            size[y] += size[x];
            rank[y]++;
        }
    }
}