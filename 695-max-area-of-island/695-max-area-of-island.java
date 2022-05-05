class Solution {
    static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int marker(int[][] grid,int i,int j){
        int size=1;
        grid[i][j]=0;
        for(int k=0;k<dir.length;k++){
            int r=i+dir[k][0];
            int c=j+dir[k][1];
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length &&  grid[r][c]==1){
                size+=marker(grid,r,c);
            }
        }
        return size;
    }
    public int maxAreaOfIsland(int[][] grid) {
       int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(grid[i][j]==1){
                  int size=marker(grid,i,j);
                  ans=Math.max(size,ans);
                  
              }  
            }
        }
        return ans; 
    }
}