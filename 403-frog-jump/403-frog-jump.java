class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();
        for(int stone : stones){
            hm.put(stone,new HashSet<>());
        }
        hm.get(stones[0]).add(1);
        for(int i = 0;i<stones.length;i++){
            int stone = stones[i];
            for(int j:hm.get(stone)){
                int y = stone + j;
                if(hm.containsKey(y)){
                    hm.get(y).add(j);
                    if(j-1>0)
                        hm.get(y).add(j-1);
                    hm.get(y).add(j+1);
                }
            }
            
        }
        int n = stones.length;
        int le = stones[n-1];
        if(hm.get(le).size()>0){
            return true;
        }
        return false;
    }
}