class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n =nums.length;
        int hi = nums[n-1]-nums[0];
        
        int lo = Integer.MAX_VALUE;
        for(int i =0;i<n-1;i++){
            lo = Math.min(nums[i+1]-nums[i],lo);
        }
        System.out.print(lo+" "+hi);

        
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            
            int j = 1;
            int count = 0;
            for(int i = 0;i<n;i++){
                while(j<n && nums[j]-nums[i]<=mid){
                    j++;
                }
                count+=j-i-1;
            }
            
            if(count<k){
                lo = mid+1;
                
            }
            else{
                hi = mid;
            }
        }
        
        return lo;
    }
}