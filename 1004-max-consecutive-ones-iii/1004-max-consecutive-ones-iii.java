class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int w = 0;
        int ans = 0;
        int j =0;
        while(j<nums.length){
            if(nums[j]==0)
                w++;
                
            while(w>k){
                if(nums[i]==0){
                    w--;
                }
                i++;
            }
            ans = Math.max(ans,j-i+1);

            j++;
        }
      return ans;  
    }
}
// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int ans = Integer.MIN_VALUE;
        
//         for(int i = 0;i<nums.length;i++){
//             int count = 0;
//             int idx = i;
//             int l = 0;
//             while(count<k && idx<nums.length){
//                 if(nums[idx]==0){
//                     count++;
//                 }
//                 l++;
//                 idx++;
//             }
//             ans = Math.max(ans,l);
//         }
//         return ans;
//     }
// }