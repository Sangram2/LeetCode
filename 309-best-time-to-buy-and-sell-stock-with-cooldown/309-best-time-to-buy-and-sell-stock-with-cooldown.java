class Solution {
    public int maxProfit(int[] prices) {
        int b = -prices[0];
        int s = 0;
        int c = 0;
        for(int i=1;i<prices.length;i++){
            int val = prices[i];
            
            int nb = Math.max(c-val,b);
            int ns = Math.max(b+val,s);
            int nc = Math.max(c,s);
            
            b = nb;
            s = ns;
            c = nc;
        }
        return s;
    }
}
