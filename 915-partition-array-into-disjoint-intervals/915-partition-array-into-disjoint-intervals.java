class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        
        int m =nums[0];
        int n = nums[nums.length-1];
        
        for(int i =0;i<nums.length;i++){
            if(i==0){
                max[i] = m;
            }
            else{
                max[i] = Math.max(max[i-1],nums[i]);
            }
        }
        for(int i =nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                min[i] = n;
            }
            else{
                min[i] = Math.min(min[i+1],nums[i]);
            }
        }
        
        for(int ele: max){
            System.out.print(ele+" ");
        }
        int ans =0;
        for(int i=0;i<nums.length-1;i++){
            if(max[i]<=min[i+1]){
                ans = i;
                break;
                
            }
        }
        return ans+1;
    }
}