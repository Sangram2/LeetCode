class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for(int g = 0; g < dp[0].length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                if(g == 0){
                    dp[i][j] = 1;
                } else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j)? 2: 1;
                } else {
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        
        return dp[0][dp[0].length - 1];
    }
    
//      public int longestPalindromeSubseq(String s) {
//         String text1 = s;
//         StringBuilder sb = new StringBuilder(s);
//         sb.reverse();
//         String text2 = sb.toString();
//         int ans = longestCommonSubsequence(text1,text2);
//         return ans;
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n1 = text1.length();
//         int n2 = text2.length();
//         int[][] dp = new int[n1+1][n2+1];
//         for(int i =0;i<dp.length;i++){
//             for(int j = 0;j<dp[0].length;j++){
//                 if(i==0 || j==0){
//                     dp[i][j] = 0;
//                 }
//                 else{
//                     if(text1.charAt(i-1) == text2.charAt(j-1)){
//                         dp[i][j] = dp[i-1][j-1]+1;
//                     }else{
//                         dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//                     }
//                 }
//             }
//         }
        
//         return dp[dp.length-1][dp[0].length-1];
//     }
}