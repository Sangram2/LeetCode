class Solution {
    boolean[][] p;
    public int minCut(String s) {
        if(s.length() == 1){
            return 0;
        }
        p = new boolean[s.length()][s.length()];
        isPalin(s);
        
        int[] dp = new int[s.length()];
        dp[0] = 0;
        dp[1] = s.charAt(0) == s.charAt(1)?0:1;
        for(int j = 2;j<s.length();j++){
            if(p[0][j] == true){
                dp[j] = 0;
            }else{
                dp[j] = Integer.MAX_VALUE;
            
                for(int i = j;i>0;i--){
                    if(p[i][j] == true)
                        dp[j] = Math.min(dp[j],1+dp[i-1]);
                }
            }
            
        }
        return dp[dp.length-1];
        
    }
    void isPalin(String s){
        for(int g = 0;g<s.length();g++){
            for(int i = 0,j= g;j<s.length();i++,j++){
                if(g==0){
                    p[i][j] = true;
                }
                else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        p[i][j] = true;
                    }else{
                        p[i][j] = false;
                    }
                }
                else{
                    p[i][j] = s.charAt(i) == s.charAt(j) && p[i+1][j-1] == true;
                }
            }
        }
    }
}

// class Solution {
//     public int minCut(String s) {
//         int[][] dp = new int[s.length()][s.length()];
//         for(int g = 0;g<s.length();g++){
//             for(int i = 0,j = g;j<s.length();i++,j++){
//                 if(g == 0){
//                     dp[i][j] = 0;
//                 }
//                 else if(g == 1){
//                     if(s.charAt(i) == s.charAt(j)){
//                         dp[i][j] = 0;
//                     }
//                     else{
//                         dp[i][j] = 1;
//                     }
//                 }
//                 else{
                    
//                     if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 0){
//                         dp[i][j] = 0;
//                     }
//                     else{
//                         dp[i][j] = Integer.MAX_VALUE;
//                         for(int k1 = 1,k2 = g;k2>=1;k2--,k1++){
//                             int left = dp[i][j-k2];
//                             int right = dp[i+k1][j];
//                             int val = 1;
//                             dp[i][j] = Math.min(dp[i][j],left+right+1);

//                         }
//                     }
//                 }
//             }
//         }
        
//         return dp[0][dp.length-1];
//     }
// }