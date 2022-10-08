class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest_Sum=1000000000;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int s=i+1;
            int e=n-1;
            while(s<e){
                int sum=nums[i]+nums[s]+nums[e];
                if(Math.abs(target-sum)<Math.abs(target-closest_Sum)){
                    closest_Sum=sum;
                }if(sum==target){
                    return target;
                }
                
                else if(sum>target){
                     e--;
                }
                else {
                     s++;
                }
                
            }
        }
        return closest_Sum;
        
    }
}