class Solution {
//     public int jump(int[] jumps) {
//         int n = jumps.length;
//         int[] dp = new int[n];
//         int ans = tabulation(n,jumps,dp);
//         return ans;
//     }
//     public int tabulation(int n, int[] jumps,int[] dp){
//         for(int i = n-1;i>=0;i--){
//             if(i == n-1){
//                 dp[i] = 0;
//                 continue;
//             }
//             int ans = Integer.MAX_VALUE;
//             for(int j = 1;j<=jumps[i] && i+j<n;j++){
//                 ans = Math.min(dp[i+j],ans);
                    
//             }
//             if(ans == Integer.MAX_VALUE){
//                 dp[i] = Integer.MAX_VALUE;
//             }else{
//                 dp[i] = ans+1; 
//             }
            
//         }
//         return dp[0];
//     }
    
    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        
        int ans = 0;
        
        int curr = 0;
        int prev = 0;
        while(curr < nums.length){
            if(curr + nums[curr] >= nums.length - 1){
                ans++;
                break;
            }
            
            int inter = curr;
            for(int j = prev + 1; j <= curr + nums[curr] && j < nums.length; j++){
                if(j + nums[j] >= inter + nums[inter]){
                    inter = j;
                }
            }
            
            prev = curr + nums[curr];
            curr = inter;
            ans++;
        }
        
        
        return ans;
    }

    
}