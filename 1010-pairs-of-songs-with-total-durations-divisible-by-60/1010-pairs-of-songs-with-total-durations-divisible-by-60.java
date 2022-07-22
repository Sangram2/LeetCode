class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int song:time){
            int add = song%60;
            int req = (60-(song%60))%60;
            
            if(hm.containsKey(req)){
                count += hm.get(req); 
            }
            if(hm.containsKey(add)){
                hm.put(add,hm.get(add)+1);
            }else{ 
                hm.put(add,1);
            }
            
        }
        return count;
    }
}