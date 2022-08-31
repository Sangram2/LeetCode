class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int lp = prices[0];
        
        for(int i = 1;i<prices.length;i++){
            lp = Math.min(prices[i],lp);
            int c = prices[i]-lp;
            ans = Math.max(ans,c);
        }
        return ans;
    }
}