class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(i == 0){
                    dp[i][j] = 1; 
                }
                else if(j == 0){
                    dp[i][j] = 0;
                }
                else {
                    if(t.charAt(i-1) == s.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                        
                    }
                    else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}