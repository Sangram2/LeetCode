// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         int[] ans = new int[nums.length];
//         int st = 0;
//         int end = nums.length-1;
//         int idx = nums.length-1;
//         while(st<=end){
//             int l = Math.abs(nums[st]);
//             int r = Math.abs(nums[end]);
//             if(l<r){
//                 ans[idx--] = r*r;
//                 end--;
//             }
//             else{
//                 ans[idx--] = l*l;
//                 st++;
//             }
            
//         }
//         return ans;
//     }
// }
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int st = 0;
        int end = nums.length-1;
        int idx = nums.length-1;
        while(idx>=0){
            int l = Math.abs(nums[st]);
            int r = Math.abs(nums[end]);
            if(l<r){
                ans[idx--] = r*r;
                end--;
            }
            else{
                ans[idx--] = l*l;
                st++;
            }
            
        }
        return ans;
    }
}