class Solution {
    public int change(int tar, int[] coins) {
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int c:coins){
            for(int i =1;i<dp.length;i++){
                if((i-c)>=0){
                    dp[i] += dp[i-c];
                }
            }
        }
        return dp[dp.length-1];
    }
}