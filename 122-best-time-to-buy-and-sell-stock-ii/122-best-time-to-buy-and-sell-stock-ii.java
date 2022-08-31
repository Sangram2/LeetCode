class Solution {
    public int maxProfit(int[] stocks) {
        int b = 0,s = 0;
        int ans = 0;
        int i = 0;
        while(i < stocks.length-1){
            while(i < stocks.length-1 && stocks[i]<=stocks[i+1] ){
                s++;
                i++;
            }
            ans += stocks[s]-stocks[b];
            b= s;
            while(i < stocks.length-1 && stocks[i]>stocks[i+1]){
                b=s;
                b++;
                s++;
                i++;
            }
            
        }
        return ans;
    
    }
}