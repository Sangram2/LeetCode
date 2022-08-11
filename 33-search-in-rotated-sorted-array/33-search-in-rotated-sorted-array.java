class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid]>nums[hi]){
                lo = mid+1 ;
                
            }
            else{
                hi = mid;
            }
        }
        
        int s1 = binarySearch(nums,0,lo-1,target);
        if(s1!=-1){
            return s1;
        }
        
        int s2 = binarySearch(nums,lo,nums.length-1,target);
        return s2;
        
    }
    
    int binarySearch(int[] arr,int lo,int hi,int tar){
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]==tar){
                return mid;
            }
            else if(arr[mid]>tar){
               hi = mid-1;
            }
            else{
                
                 lo = mid+1;
            }
            
        }
        return -1;
    }
}