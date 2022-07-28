class Solution {
    public int maxProduct(int[] nums) {
      int p =1;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(p==0){
                res = Math.max(res,p);
                p = 1;
            }
            p *= nums[i];
            res = Math.max(res,p);
        }
        p=1;
        for(int i=nums.length-1;i>=0;i--){
            if(p==0){
                res = Math.max(res,p);
                p = 1;
            }
            p *= nums[i];
            res = Math.max(res,p);
        }
        return res;
    }
}