class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n][target];
        long mod = (long)1e9+(long)7;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<target;j++){
                if(i == 0 && j<k){
                    dp[i][j] = 1L;
                }else if(i == 0){
                    continue;
                }
                else{
                    int c = 0;
                    int s = j-1;
                    long sum = 0;
                    while(s>=0 && c<k){
                        sum += dp[i-1][s];
                        sum = sum%mod;
                        s--;
                        c++;
                    }
                    dp[i][j] = sum;
                }
            }
        }
        return (int)dp[n-1][target-1];
    }
}