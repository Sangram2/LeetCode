class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int max = Integer.MIN_VALUE;
        for(int ele:piles){
            max = Math.max(max,ele);
        }
        
        int hi = max;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            int hReq = 0;
            for(int ele:piles){
                hReq += (ele+mid-1)/mid; 
            }
            if(hReq>h){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
        
    }
}