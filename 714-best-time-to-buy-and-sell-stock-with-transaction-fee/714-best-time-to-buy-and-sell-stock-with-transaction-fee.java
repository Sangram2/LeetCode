class Solution {
    public int maxProfit(int[] prices, int fee) {
        int bsp = -prices[0];
        int ssp = 0;
        for(int i=1;i<prices.length;i++){
            int val = prices[i];
            int x = ssp-val;
            int y = val-fee+bsp;
            bsp = Math.max(bsp,x);
            
            ssp = Math.max(ssp,y);
        }
        return ssp;
    }
}