class Solution {
    public int jump(int[] jumps) {
        int n = jumps.length;
        int[] dp = new int[n];
        int ans = tabulation(n,jumps,dp);
        return ans;
    }
    public int tabulation(int n, int[] jumps,int[] dp){
        for(int i = n-1;i>=0;i--){
            if(i == n-1){
                dp[i] = 0;
                continue;
            }
            int ans = Integer.MAX_VALUE;
            for(int j = 1;j<=jumps[i] && i+j<n;j++){
                ans = Math.min(dp[i+j],ans);
                    
            }
            if(ans == Integer.MAX_VALUE){
                dp[i] = Integer.MAX_VALUE;
            }else{
                dp[i] = ans+1; 
            }
            
        }
        return dp[0];
    }
    
}