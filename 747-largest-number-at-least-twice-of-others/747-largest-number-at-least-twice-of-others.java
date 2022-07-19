// class Solution {
//     public int dominantIndex(int[] nums) {
//         int idx1 = -1;
//         int idx2 = -1;
//         int max1 = Integer.MIN_VALUE;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]>max1){
//                 max1 = nums[i];
//                 idx1 = i;
//             }
//         }
//         int max2 = Integer.MIN_VALUE;
//         for(int i =0;i<nums.length;i++){
//             if(i==idx1){
//                 continue;
//             }
//             else if(nums[i]>max2){
//                 max2 = nums[i];
                
//             }
//         }
        
//         if(max1>=2*max2){
//             return idx1;
//         }else{
//             return -1;
//         }
//     }
// }


class Solution {
    public int dominantIndex(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(idx1 == -1 || nums[i] >= nums[idx1]){
                idx2 = idx1;
                idx1 = i;
            } else if(idx2 == -1 || nums[i] >= nums[idx2]){
                 idx2 = i;
            }
        }
        
        if(nums[idx1] >= 2 * nums[idx2]){
            return idx1;
        } else {
            return -1;
        } 
    }
}
