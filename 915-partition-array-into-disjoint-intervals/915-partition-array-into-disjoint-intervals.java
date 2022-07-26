class Solution {
    public int partitionDisjoint(int[] nums) {
        int mtp = nums[0];
        int ms = nums[0];
        int par = 0;
        for(int i=0;i<nums.length;i++){
            ms = Math.max(ms,nums[i]);
            if(nums[i]<mtp){
                par = i;
                mtp = ms;
            }
        }
        return par+1;
    }
}
// class Solution {
//     public int partitionDisjoint(int[] nums) {
//         int[] min = new int[nums.length];
//         int[] max = new int[nums.length];
        
//         int m =nums[0];
//         int n = nums[nums.length-1];
        
//         for(int i =0;i<nums.length;i++){
//             if(i==0){
//                 max[i] = m;
//             }
//             else{
//                 max[i] = Math.max(max[i-1],nums[i]);
//             }
//         }
//         for(int i =nums.length-1;i>=0;i--){
//             if(i==nums.length-1){
//                 min[i] = n;
//             }
//             else{
//                 min[i] = Math.min(min[i+1],nums[i]);
//             }
//         }
        
        
//         int ans =0;
//         for(int i=0;i<nums.length-1;i++){
//             if(max[i]<=min[i+1]){
//                 ans = i;
//                 break;
                
//             }
//         }
//         return ans+1;
//     }
// }