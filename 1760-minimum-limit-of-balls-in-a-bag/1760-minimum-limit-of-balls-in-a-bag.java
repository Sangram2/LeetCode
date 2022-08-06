class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo =1;
        int max = Integer.MIN_VALUE;
        for(int ele:nums){
            max = Math.max(max,ele);
        }
        
        int hi = max;
        
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            
            int opReq = 0;
            for(int ele:nums){
                if(ele>mid){
                    int spare = ele-mid;
                    int res = (spare+mid-1)/mid;
                    opReq += res;
                }
            }
            
            if(opReq>maxOperations){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}