class Solution {
    public long minimumReplacement(int[] nums) {
        int n =nums.length;
        long limit = nums[n-1];
        long optr = 0;
        for(int i= n-2;i>=0;i--){
            if(nums[i]>limit){
                long spare = nums[i]-limit;
                long l = (spare+limit-1)/limit;
                optr += l;
                if(spare%limit==0){
                    //do nothing
                }
                else{
                    limit = nums[i]/(l+1);
                }
            }
            else{
                limit = nums[i];
            }
        }
        return optr;
    }
}