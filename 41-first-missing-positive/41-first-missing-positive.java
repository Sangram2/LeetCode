class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        
        for(int i = 0;i<n;i++){
            if(nums[i]<=0 || nums[i]>n){
                nums[i] = n+1;
            }
            
            
        }
        
        for(int i = 0;i<n;i++){
            int abs = Math.abs(nums[i]);
            if(abs>0 && abs<=n){
                if(nums[abs-1]>0){
                    nums[abs-1] = -nums[abs-1];
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}