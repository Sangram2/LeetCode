// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int[][] dp = new int[k+1][prices.length];
//         if(k==0 || prices.length==0){
//             return 0;
//         }
//         for(int i=1;i<dp.length;i++){
//             for(int j=1;j<prices.length;j++){
//                 int g = dp[i][j-1];
//                 for(int h=0;h<j;h++){
//                     g = Math.max(g,dp[i-1][h]+prices[j]-prices[h]);
//                 }
//                 dp[i][j] = g;
//             }
            
//         }
//         return dp[dp.length-1][dp[0].length-1];
//     }
// }

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0){
            return 0;
        }
        int[][] dp = new int[k + 1][prices.length];
        
        for(int i = 1; i <= k; i++){
            int maxp = Integer.MIN_VALUE;
            
            for(int j = 1; j < prices.length; j++){
                maxp = Math.max(maxp, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(maxp + prices[j], dp[i][j - 1]);
            }
        }
        
        return dp[k][prices.length - 1];
    }
}