class Solution {
    
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        
        for(int[] trip : trips){
            int to = trip[1];
            int from = trip[2];
            int np = trip[0];
            
            arr[to] += np;
            arr[from] -= np;
        }
        
        int cap = 0;
        for(int i = 0;i<1001;i++){
            cap+=arr[i];
            if(cap>capacity){
                return false;
            }
            
        }
        return true;
    }
}