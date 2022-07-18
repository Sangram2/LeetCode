class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int st = -1;
        int en = -1;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=left && nums[i]<=right){
                en=i;
                ans+=en-st;
            }
            else if(nums[i]>right){
                st=en=i;
            }else{
                ans+=en-st;
            }
        }
        return ans;
    }
}