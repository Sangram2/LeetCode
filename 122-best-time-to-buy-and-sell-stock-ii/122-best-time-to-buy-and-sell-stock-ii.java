class Solution {
    public int maxProfit(int[] stocks) {
        int b = 0,s = 0;
        int ans = 0;
        // int i = 0;
        while(s < stocks.length-1){
            while(s < stocks.length-1 && stocks[s]<=stocks[s+1] ){
                s++;
                // i++;
            }
            ans += stocks[s]-stocks[b];
            b= s;
            while(s < stocks.length-1 && stocks[s]>stocks[s+1]){
                // b=s;
                b++;
                s++;
                // i++;
            }
            
        }
        return ans;
    
    }
}