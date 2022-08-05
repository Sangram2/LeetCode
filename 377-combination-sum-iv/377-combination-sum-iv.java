class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]= 1;
        for(int i=1;i<dp.length;i++){
            int count=0;
            for(int ele:nums){
               if(i-ele>=0){
                   count+=dp[i-ele];
               } 
                dp[i]=count;
            }
        }
        return dp[dp.length-1];
    }
}