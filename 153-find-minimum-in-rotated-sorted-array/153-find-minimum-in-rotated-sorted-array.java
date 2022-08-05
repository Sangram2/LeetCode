// class Solution {
//     public int findMin(int[] nums) {
//         int i  =0;
//         int j = nums.length-1;
//         while(i<=j){
//             int mid = i+(j-i)/2;
//             if(((mid==nums.length-1)||(nums[mid]<nums[mid+1])) && ((mid==0)||(nums[mid]<nums[mid-1]))){
//                 return nums[mid];
//             }
//             else if(nums[mid]>nums[j]){
//                 i = mid+1;
//             }
//             else if(nums[mid]<nums[j]){
//                 j = mid-1;
//             }
//         }
//         return Integer.MIN_VALUE;
        
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
            } else {
                lo = mid + 1;
            }
        }
        
        return nums[hi];//return nums[lo]-> will also work here.
    }
}