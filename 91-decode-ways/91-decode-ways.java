class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int [] dp=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        // int ans=CountEncode(s,0,dp);
        int ans=CountEn_Tab(s,0,dp);
        return ans;
        
    }
    public int CountEncode(String str,int idx,int[] dp){
        if(idx==str.length()){
            return dp[idx]=1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        char ch=str.charAt(idx);
        if(ch=='0'){
            return dp[idx]=0;
        }
        int count = CountEncode(str,idx+1,dp);
        
        if(idx<str.length()-1){
            char ch2=str.charAt(idx+1);
            int c1=ch-'0';
            int c2=ch2-'0';
            int num=(c1*10)+c2;
            if(num<=26){
                count+=CountEncode(str,idx+2,dp);
            }
        }
        return dp[idx] = count;
        
    }
    public int CountEn_Tab(String str,int IDX,int[] dp){
        for(int idx=dp.length-1;idx>=0;idx--){
            if(idx==str.length()){
                dp[idx]=1;
                continue;
            }
            
            char ch=str.charAt(idx);
            if(ch=='0'){
                dp[idx]=0;
                continue;
            }
            int count = dp[idx+1];//CountEncode(str,idx+1,dp);
        
            if(idx<str.length()-1){
                char ch2=str.charAt(idx+1);
                int c1=ch-'0';
                int c2=ch2-'0';
                int num=(c1*10)+c2;
                if(num<=26){
                    count+=dp[idx+2];//CountEncode(str,idx+2,dp);
                }
            }
            dp[idx] = count;
        }
        return dp[IDX];
    }
}