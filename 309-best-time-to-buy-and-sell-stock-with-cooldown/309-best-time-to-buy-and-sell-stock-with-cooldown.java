// class Solution {
//     public int maxProfit(int[] prices) {
//         int b = -prices[0];
//         int s = 0;
//         int c = 0;
//         for(int i=1;i<prices.length;i++){
//             int val = prices[i];
            
//             int nb = Math.max(c-val,b);
//             int ns = Math.max(b+val,s);
//             int nc = Math.max(c,s);
            
//             nb = b;
//             ns = s;
//             nc = c;
//         }
//         return s;
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int b = -prices[0];
        int s = 0;
        int c = 0;
        
        for(int i = 1; i < prices.length; i++){
            int val = prices[i];
            int nbsp = Math.max(c - val, b);
            int nssp = Math.max(b + val, s);
            int ncsp = Math.max(s, c);
            
            b = nbsp;
            s = nssp;
            c = ncsp;
        }
        
        return s;
    }
}
