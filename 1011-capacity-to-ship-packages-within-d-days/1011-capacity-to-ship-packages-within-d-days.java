class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int ele:weights){
            sum += ele;
            max = Math.max(max,ele);
            
        }
        
        int lo = max;
        int hi = sum;
        
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            
            int nop = 1;
             sum = 0;
            for(int ele:weights){
                sum+=ele;
                if(sum>mid){
                    nop++;
                    sum = ele;
                }
                
            }
            
            if(nop>days){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}