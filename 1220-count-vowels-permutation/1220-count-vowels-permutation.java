class Solution {
//     int[][] dir = {{1,2,4},{0,2},{1,3},{2},{2,3}};
//     public int countVowelPermutation(int n) {
//         int[][] dp =new int[n+1][5];
//         int mod = (int)1e9+7;
//         for(int i=0;i<n+1;i++){
//             for(int j = 0;j<5;j++){
//                 if(i==0 || i==1){
//                     dp[i][j] = i;
//                 }
//                 else{
//                     int val = 0;
//                     for(int idx : dir[j]){
//                         val=((val)%mod+dp[i-1][idx])%mod;
//                     } 
//                     dp[i][j] = (val)%mod;
//                 }
//             }
//         }
        
//         int ans = 0;
//         for(int g:dp[n]){
//             ans = ((ans%mod)+g)%mod;
//         }
//         return ans;
//     }
    
     int[][] dir = {{1,2,4},{0,2},{1,3},{2},{2,3}};
    public int countVowelPermutation(int n) {
        if(n==1){
            return 5;
        }
        int[][] dp =new int[2][5];
        int mod = (int)1e9+7;
        for(int i=0;i<2;i++){
            for(int j=0;j<5;j++){
                dp[i][j] = i;
            }
        }
        int k = 1;
        while(k<n){
            for(int j=0;j<5;j++){
                dp[0][j] = dp[1][j];
            }
            for(int j=0;j<5;j++){
                int val = 0;
                for(int idx : dir[j]){
                    val=((val)%mod+dp[0][idx])%mod;
                } 
                dp[1][j] = (val)%mod;
            }
            k++;
        }
        
        int ans = 0;
        for(int g:dp[1]){
            ans = ((ans%mod)+g)%mod;
        }
        return ans;
    }
}