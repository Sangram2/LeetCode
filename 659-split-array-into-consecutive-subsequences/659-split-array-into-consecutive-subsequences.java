class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> start = new HashMap<>();
        HashMap<Integer,Integer> end = new HashMap<>();
        for(int a:nums){
            start.put(a,start.getOrDefault(a,0)+1);
            
        }
        
        for(int a:nums){
            if(start.get(a)<=0){
                continue;
            }
            start.put(a,start.get(a)-1);
            
            if(end.containsKey(a-1) && end.get(a-1)>0){
                end.put(a-1,end.get(a-1)-1);
                end.put(a,end.getOrDefault(a,0)+1);
                continue;
            }
            
            if(start.containsKey(a+1) && start.get(a+1)>0 && start.containsKey(a+2) && start.get(a+2)>0){
                start.put(a+1,start.get(a+1)-1);
                start.put(a+2,start.get(a+2)-1);
                end.put(a+2,end.getOrDefault(a+2,0)+1);
                continue;
            }
            
            
            //cannot place a so reurn false
            return false;
        }
        
        return true;
        
        
        
    }
    
     
}