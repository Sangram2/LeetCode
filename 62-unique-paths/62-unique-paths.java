class Solution {
    
    public int count(int sr,int sc,int dr,int dc,int[][]dp){
        if(sr==dr && sc== dc){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }
        int c=0;
        if(sr+1<=dr)
            c+=count(sr+1,sc,dr,dc,dp);
        if(sc+1<=dc)
            c+=count(sr,sc+1,dr,dc,dp);
        return dp[sr][sc]=c;
        
        
    }
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return count(0,0,m-1,n-1,dp);
    }
}