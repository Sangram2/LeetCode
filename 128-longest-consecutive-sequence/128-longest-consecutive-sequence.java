class Solution {
    HashMap<Integer,Integer> parent;
    HashMap<Integer,Integer> rank;
    HashMap<Integer,Integer> size;
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        parent = new HashMap<>();
        rank = new HashMap<>();
        size = new HashMap<>();
        
        for(int val : nums){
            parent.put(val,val);
            rank.put(val,0);
            size.put(val,1);
        }
        
        for(int n : nums){
            int nlead = find(parent.get(n));
            if(parent.containsKey(n-1)){
                int prevlead = find(parent.get(n-1));
                if(nlead!=prevlead){
                    union(nlead,prevlead);
                }
            }
            nlead = find(parent.get(n));
            if(parent.containsKey(n+1)){
                int nextlead = find(parent.get(n+1));
                if(nlead!=nextlead){
                    union(nlead,nextlead);
                }
            }
        }
        int ans = 1;
        for(int n : nums){
            if(parent.get(n)==n){
                ans = Math.max(ans,size.get(n));
            }
        }
        return ans;
    }
    
    int find(int x){
        if(parent.get(x)==x){
            return x;
        }
        else{
            parent.put(x,find(parent.get(x)));
            return parent.get(x);
        }
    }
    
    void union(int x,int y){
        if(rank.get(x)>rank.get(y)){
            parent.put(y,x);
            size.put(x,size.get(x)+size.get(y));
        }
        else if(rank.get(x)<rank.get(y)){
            parent.put(x,y);
            size.put(y,size.get(x)+size.get(y));
        }
        else{
            parent.put(x,y);
            size.put(y,size.get(x)+size.get(y));
            rank.put(y,rank.get(y)+1);
        }
    }
}