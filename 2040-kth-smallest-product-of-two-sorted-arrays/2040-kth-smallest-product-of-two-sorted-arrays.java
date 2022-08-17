class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long lo = (long) -1e10;
        long hi = (long) 1e10;
        
        while(lo<hi){
            long mid = lo+(hi-lo)/2;
           
            long count = find(nums1,nums2,mid);
            
            if(count>=k){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
            
        }
        return lo;
    }
    
    long find(int[] nums1,int[] nums2,long limit){
        long count =0;
        for(long ele:nums1){
            if(ele>0){
                int lo = 0;
                int hi = nums2.length-1;
                while(lo<=hi){
                    int mid = lo+(hi-lo)/2;
                    long res = ele*nums2[mid];
                    if(res<=limit){
                        lo = mid+1;
                    }else{
                        hi = mid-1;
                    }
                }
                count+=lo;
            }
            else{
                int lo = 0;
                int hi = nums2.length-1;
                while(lo<=hi){
                    int mid = lo+(hi-lo)/2;
                    long res = ele*nums2[mid];
                    if(res<=limit){
                        hi = mid-1;
                    }else{
                        lo = mid+1;
                    }
                }
                count += nums2.length-hi-1;  
            }
        }
        return count;
    }
}