class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int xC = startFuel;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int[] s:stations){
            int station = s[0];
            int fuel = s[1];
            while(xC<station){
                if(pq.size()==0){
                    return -1;
                }
                int maxF = pq.remove();
                xC += maxF;
                ans++;
            }
            pq.add(fuel);
  
        }

        while(xC<target){
            if(pq.size()==0){
                return -1;
            }
            int maxF = pq.remove();
            xC += maxF;
            ans++;  
        }
        return ans;
    }
}