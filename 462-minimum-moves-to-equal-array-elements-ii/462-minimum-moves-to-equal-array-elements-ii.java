class Solution {
    public int minMoves2(int[] nums) {
       int n=nums.length;
        
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if(n%2==0){
            int mid2 = n/2;
            int mid1 = mid2-1;
            
            int m1ele = nums[mid1];
            int m2ele = nums[mid2];
            int ans1 = calculate_val(nums,m1ele);
            int ans2 = calculate_val(nums,m2ele);
            ans = Math.min(ans,Math.min(ans1,ans2));
            
        }
        else{
            int mid = n/2;
            int mele = nums[mid];
            ans = Math.min(ans,calculate_val(nums,mele));
        }
        return ans;
        
    }
    
    int calculate_val(int[] nums,int c){
        int rev = 0;
        for(int v : nums){
            rev += Math.abs(v-c);
           
        }
        return rev;
    }
}