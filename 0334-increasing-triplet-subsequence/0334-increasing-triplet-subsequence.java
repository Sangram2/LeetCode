class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int len = 1;
        int[] tail = new int[n];
        tail[0] = nums[0];
        
        for(int i = 0;i<n;i++){
            if(nums[i]>tail[len-1]){
                len++;
                tail[len-1] = nums[i];
            }
            else{
                int idx = Arrays.binarySearch(tail,0,len-1,nums[i]);
                
                if(idx<0){
                    idx = -idx;
                    idx = idx-1;
                }
                tail[idx] = nums[i];
            }
        }
        
        return len>=3?true:false;
        
    }
}