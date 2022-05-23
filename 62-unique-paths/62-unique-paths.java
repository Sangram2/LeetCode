class Solution {
    
    public int[][]dir= {{1,0},{0,1}};
    
    public int count(int sr,int sc,int dr,int dc,int[][]dp){
        if(sr==dr && sc== dc){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int a=0;
        for(int i=0;i<dir.length;i++){
            int r=sr+dir[i][0];
            int c= sc+dir[i][1];
            if(r<=dr && c<=dc){
                a+=count(r,c,dr,dc,dp);
            }
        }
        return dp[sr][sc]=a;
        
        
    }
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m][n];
        
        return count(0,0,m-1,n-1,dp);
    }
}