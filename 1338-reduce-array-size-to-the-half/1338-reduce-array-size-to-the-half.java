class Solution {
    class pair{
        int val;
        int freq;
        pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }
        
    }
    public int minSetSize(int[] nums) {
        int n = nums.length;
        int limit = n/2;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int ele:nums){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            return b.freq-a.freq;
        });
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            pq.add(new pair(entry.getKey(),entry.getValue()));
        }
        
        int count = 0;
        int ans = 0;
        while(count<limit){
            ans++;
            count+=pq.remove().freq;
        }
        return ans;
    }
}