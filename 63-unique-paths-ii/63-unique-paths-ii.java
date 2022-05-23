class Solution {
    
    public int[][]dir= {{1,0},{0,1}};
     public int count(int sr,int sc,int dr,int dc,int[][] obstacleGrid,int[][]dp){
        if(sr==dr && sc== dc && obstacleGrid[sr][sc]==0){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int a=0;
        for(int i=0;i<dir.length;i++){
            int r=sr+dir[i][0];
            int c= sc+dir[i][1];
            if(r<=dr && c<=dc && obstacleGrid[r][c]==0){
                a+=count(r,c,dr,dc,obstacleGrid,dp);
            }
        }
        return dp[sr][sc]=a;
        
        
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][] dp=new int[m][n];
        
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1){
            return 0;
            
        }
        
        return count(0,0,m-1,n-1,obstacleGrid,dp);
        
    }
}

    
    
   
