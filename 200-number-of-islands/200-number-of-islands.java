class Solution {
    static int[][] dir={{1,0},{0,1},{0,-1},{-1,0}};
    
    public void marker(char[][] grid,int i,int j){
        grid[i][j]='0';
        for(int [] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r < grid.length && r >= 0 &&  c < grid[0].length && c >= 0 && grid[r][c] == '1')
                marker(grid, r, c);
        }
        
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(grid[i][j]=='1'){
                  count++;
                  marker(grid,i,j);
              }  
            }
        }
        return count;
    }
}