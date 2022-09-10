class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        
        for(int g = 0;g<n;g++){
            for(int i = 0,j = g;j<n;j++,i++){
                if(g==0){
                    dp[i][j] = 0;
                }
                else if(g==1){
                    dp[i][j] = 0;                    
                }else if(g==2){
                    dp[i][j] = values[i]*values[i+1]*values[i+2];
                }
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int lk = g-1,rk = 1;lk>=1;lk--,rk++){
                        
                        int left = dp[i][j-lk];
                        int right = dp[i+rk][j];
                        int val =  values[i]*values[i+rk]*values[j];
                        
                        dp[i][j] = Math.min(dp[i][j],left+right+val);
                    }
                }
            }
        }
        
        return dp[0][dp.length-1];
    }
}