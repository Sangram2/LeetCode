class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int mLen = 0;
        int n = s.length();
        if(n<2){
            return s;
        }
        int[][] dp = new int[n][n];
        for(int g = 0;g<n;g++){
            for(int j = g,i = 0;j<n;i++,j++){
                if(g==0){
                    dp[i][j] = 1;
                    int len = j-i+1;
                    if(len>mLen){
                        mLen = len;
                        ans =  s.substring(i,j+1);
                    }
                }
                else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                        int len = j-i+1;
                        if(len>mLen){
                            mLen = len;
                            ans =  s.substring(i,j+1);
                        }
                    }
                }
                else{
                    if((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                        int len = j-i+1;
                        if(len>mLen){
                            mLen = len;
                            ans =  s.substring(i,j+1);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}