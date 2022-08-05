class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int min = Integer.MIN_VALUE;
        
        for(int ele:nums){
            sum += ele;
            min = Math.max(min,ele);
            
        }
        
        int lo = min;
        int hi = sum;
        
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            
            int nop = 1;
            sum = 0;
            for(int ele:nums){
                sum+=ele;
                if(sum>mid){
                    nop++;
                    sum = ele;
                }
                
            }
            if(nop>m){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
      return lo;  
        
    }
}