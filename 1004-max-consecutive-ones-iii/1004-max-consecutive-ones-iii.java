class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int w = 0;
        int ans = 0;
       
        for(int j = 0;j<nums.length;j++){
            if(nums[j]==0)
                w++;
                
            while(w>k){
                if(nums[i]==0){
                    w--;
                }
                i++;
            }
            ans = Math.max(ans,j-i+1);

            
        }
      return ans;  
    }
}
