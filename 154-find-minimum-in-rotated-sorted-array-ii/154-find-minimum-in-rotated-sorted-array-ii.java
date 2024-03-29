// class Solution {
//     public int findMin(int[] nums) {
//        int ans = Integer.MAX_VALUE;
//         for(int ele:nums){
//             ans = Math.min(ans,ele);
//         }
//         return ans;
//     }
// }
// class Solution {
//     public int findMin(int[] nums) {
//         int lo = 0;
//         int hi = nums.length-1;
//         while(lo<hi){
//             int mid = lo+(hi-lo)/2;
            
//             if(nums[mid]<nums[hi]){
//                 hi = mid;
//             }
//             else if(nums[mid]>nums[hi]){
//                 lo = mid+1;
//             }
//             else{
//                 hi--;
//             }
//         }
//         return nums[lo];
//     }
// }
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[hi]){
                hi = mid;
            } else if(nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                if(nums[hi] < nums[hi - 1]){
                    lo = hi;
                    break;
                } else {
                    hi--;
                }
            }
        }
        
        return nums[lo];
    }
}