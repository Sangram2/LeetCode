class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        
        long count = 1L*n*(n-1)/2;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            int key = nums[i]-i;
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        
        long rej = 0;
        for(int k:hm.keySet()){
            if(hm.get(k)>1){
                int h = hm.get(k);
                rej += 1L*h*(h-1)/2;
            }
        }
 
        return count-rej;
        
        
    }
}