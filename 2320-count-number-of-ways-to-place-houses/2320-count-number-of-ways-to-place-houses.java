class Solution {
    int mod = 1000000007;
    public int countHousePlacements(int n) {
        long[] dp = new long[n+1];
        long count = (find(n,dp))%mod;
        return (int)((count*count)%mod);
    }
    
    public long find(int n,long[] dp){
        if(n<2){
            return dp[n]=n+1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        long ans = ( (find(n-1,dp) % mod) + (find(n-2,dp) % mod) ) % mod;
        dp[n] = ans;
        return dp[n];
        
    }
}