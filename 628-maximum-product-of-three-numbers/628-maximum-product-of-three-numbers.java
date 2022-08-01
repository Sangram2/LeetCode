class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int p = 1;
        for(int i=nums.length-1;i>=nums.length-3;i--){
            p *= nums[i]; 
        }
        int prd = 1;
            for(int i =0;i<2;i++){
                prd *= nums[i];
            }
        return Math.max(prd*nums[nums.length-1],p);
    }
}