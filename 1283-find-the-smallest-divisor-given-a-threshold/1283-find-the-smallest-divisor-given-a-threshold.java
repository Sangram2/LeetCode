// class Solution {
//     public int smallestDivisor(int[] nums, int threshold) {
//         int sum = Integer.MIN_VALUE;
//         for(int ele:nums){
//             sum=Math.max(ele,sum);
//         }
//         int lo = 1;
//         int hi = sum;
        
//         int ans = Integer.MAX_VALUE;
//         while(lo<=hi){
//             int mid = lo+(hi-lo)/2;
//             int res = find(nums,mid);
            
//             if(res<=threshold){
//                 hi = mid-1;
//                 ans = Math.min(ans,mid);
//             }
//             else{
//                 lo = mid+1;
//             }
//         }
//         return ans;
    
//     }
//     int find(int[] nums,int k){
//         int h = 0;
//         for(int ele:nums){
//             if(ele%k==0){
//                 h+=ele/k;
//             }
//             else{
//                 h+=ele/k+1;
//             }
//         }
//         return h;
//     }
// }
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = 1000000;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            int sum = 0;
            for(int val: nums){
                sum += (val + mid - 1) / mid;
            }
            
            if(sum > threshold){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}