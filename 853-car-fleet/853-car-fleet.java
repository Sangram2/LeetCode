class Solution {
    class pair implements Comparable<pair>{
        int pos;
        int speed;
        
        pair(int pos,int speed){
            this.pos = pos;
            this.speed = speed;
        }
        public int compareTo(pair o){
            return o.pos-this.pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0;i<position.length;i++){
            pq.add(new pair(position[i],speed[i]));
        }
        double time = 0;
        int count =0;
        while(pq.size()!=0){
            pair p = pq.remove();
            double ctime = (target-p.pos)/(p.speed*1.0);
            
            if(ctime>time){
                count++;
                time = ctime;
            }
        }
        
        
        return count;
    }
}
// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
//         for(int i = 0; i < position.length; i++){
//             map.put(position[i], speed[i]);
//         }
        
//         double time = 0;
//         int res = 0;
//         for(Map.Entry<Integer, Integer> car: map.entrySet()){
//             double ctime = (target - car.getKey()) * 1.0 / car.getValue();
//             if(ctime > time){
//                 time = ctime;
//                 res++;
//             }
//         }
        
//         return res;
//     }
// }