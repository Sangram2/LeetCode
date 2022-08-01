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
// class Solution {
//     public int maxProduct(int[] nums) {
//         int res = nums[0];
//         int max = nums[0];
//         int min = nums[0];
        
//         for(int i = 1; i < nums.length; i++){
//             if(nums[i] >= 0){
//                 max = Math.max(max * nums[i], nums[i]);
//                 min = Math.min(min * nums[i], nums[i]);
//             } else {
//                 int temp = max;
//                 max = Math.max(min * nums[i], nums[i]);
//                 min = Math.min(temp * nums[i], nums[i]);
//             }
            
//             res = Math.max(res, max);
//         }
        
//         return res;
//     }
// }