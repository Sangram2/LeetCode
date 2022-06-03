class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count=0,sum=0;
        hm.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            
            if(hm.containsKey(sum-k)){
                count+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}