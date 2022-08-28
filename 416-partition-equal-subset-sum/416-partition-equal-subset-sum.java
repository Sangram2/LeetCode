class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val:nums){
            sum+=val;
        }
        if(sum%2==1){
            return false;
        }
        
        int target = sum/2;
        boolean check = TSS(nums,target);
        return check;
    }
    
    boolean TSS(int[] nums,int target){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];
        
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                else{
                    boolean exc = dp[i-1][j];
                    
                    int curr = nums[i-1];
                    boolean inc = false;
                    if(j-curr>=0){
                        inc = dp[i-1][j-curr];
                    }
                    dp[i][j] = inc || exc;
                }
            }
        }
        return dp[nums.length][target];
    }
}