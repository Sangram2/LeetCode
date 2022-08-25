class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
           if(a[0]!=b[0]){
               return a[0]-b[0];
           } 
           else{
                return b[1]-a[1];
           }
        });
        int n = envelopes.length;
        int[] tail = new int[n];
        int len = 1;
        tail[0] = envelopes[0][1];
        for(int i = 1;i<n;i++){
            if(envelopes[i][1]>tail[len-1]){
                len++;
                tail[len-1] = envelopes[i][1];
            }
            else{
                int idx = Arrays.binarySearch(tail,0,len-1,envelopes[i][1]);
                if(idx<0){
                    idx = -idx;
                    idx = idx-1;
                    
                }
                tail[idx] = envelopes[i][1];
            
            }
   
        }
        return len;
    }
}