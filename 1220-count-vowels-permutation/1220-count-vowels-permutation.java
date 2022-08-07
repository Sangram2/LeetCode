class Solution {
    int[][] dir = {{1,2,4},{0,2},{1,3},{2},{2,3}};
    public int countVowelPermutation(int n) {
        int[][] dp =new int[n+1][5];
        int mod = (int)1e9+7;
        for(int i=0;i<n+1;i++){
            for(int j = 0;j<5;j++){
                if(i==0 || i==1){
                    dp[i][j] = i;
                }
                else{
                    int val = 0;
                    for(int idx : dir[j]){
                        val=((val)%mod+dp[i-1][idx])%mod;
                    } 
                    dp[i][j] = (val)%mod;
                }
            }
        }
        
        int ans = 0;
        for(int g:dp[n]){
            ans = ((ans%mod)+g)%mod;
        }
        return ans;
    }
}