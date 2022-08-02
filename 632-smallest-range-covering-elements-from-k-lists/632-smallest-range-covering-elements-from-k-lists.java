class Solution {
    class pair implements Comparable<pair>{
        int li;
        int ci;
        int val;
        
        pair(int li,int ci,int val){
            this.li = li;
            this.ci = ci;
            this.val = val;
        }
        
        public int compareTo(pair o){
            return this.val-o.val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        
        int st = 0;
        int en = 0;
        
        int dis = Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++){
            pq.add(new pair(i,0,nums.get(i).get(0)));
            max = Math.max(max,nums.get(i).get(0));
        }
        
        
        while(pq.size()==nums.size()){
            pair rem  = pq.remove();
            int min = rem.val;
            int diff = max-min;
            if(diff<dis){
                st = min;
                en = max;
                dis = diff;
            }
            if(rem.ci<nums.get(rem.li).size()-1){
                pq.add(new pair(rem.li,rem.ci+1,nums.get(rem.li).get(rem.ci+1)));
                max = Math.max(max,nums.get(rem.li).get(rem.ci+1)); 
            }
            
            
        }
        
        return new int[]{st,en};
        
    }
}