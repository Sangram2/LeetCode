class Solution {
    public int countPalindromicSubsequences(String s) {
        long[][] dp = new long[s.length()][s.length()];
        long mod = (long)1e9+7;
        int[] prev = new int[s.length()];
        int[] next = new int[s.length()];
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                prev[i] = -1;       
            }
            else{
                prev[i] = hm.get(ch);
            }
            hm.put(ch,i);
        }
        
        hm.clear();
        for(int i = s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                next[i] = s.length();       
            }
            else{
                next[i] = hm.get(ch);
            }
            hm.put(ch,i);
        }
        
        for(int g = 0;g<s.length();g++){
            for(int i = 0,j = g;j<s.length();i++,j++){
                if(g==0){
                    dp[i][j] = 1L;
                    
                }
                else if(g == 1){
                    dp[i][j] = 2L;
                }
                else{
                    if(s.charAt(i) != s.charAt(j)){
                        dp[i][j] = (((dp[i][j-1]+dp[i+1][j])%mod)+mod-dp[i+1][j-1])%mod;
                    }
                    else{
                        int np = next[i];
                        int pr = prev[j];
                        
                        if(np>pr){
                            dp[i][j] = ((2*dp[i+1][j-1])%mod+2)%mod;
                            
                        }
                        else if(np == pr){
                            dp[i][j] = ((2*dp[i+1][j-1])%mod + 1)%mod;
                        }
                        else{
                            dp[i][j] = ((2*dp[i+1][j-1])%mod - dp[np+1][pr-1]+mod)%mod;
                        }
                    }
                }
            }
        }
        
        return (int)(dp[0][dp.length-1]%mod);
    }
}