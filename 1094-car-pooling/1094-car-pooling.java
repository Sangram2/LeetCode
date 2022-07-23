// class Solution {
    
//     public boolean carPooling(int[][] trips, int capacity) {
//         int[] arr = new int[1001];
        
//         for(int[] trip : trips){
//             int to = trip[1];
//             int from = trip[2];
//             int np = trip[0];
            
//             arr[to] += np;
//             arr[from] -= np;
//         }
        
//         int cap = 0;
//         for(int i = 0;i<1001;i++){
//             cap+=arr[i];
//             if(cap>capacity){
//                 return false;
//             }
            
//         }
//         return true;
//     }
// }

// class Solution {
//     public boolean carPooling(int[][] trips, int capacity) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         ArrayList<Integer> stops = new ArrayList<>();
        
//         for(int[] trip: trips){
//             int people = trip[0];
//             int from = trip[1];
//             int to = trip[2];
            
//             if(map.containsKey(from) == false){
//                 map.put(from, +people);
//                 stops.add(from);
//             } else {
//                 map.put(from, map.get(from) + people);
//             }
            
//             if(map.containsKey(to) == false){
//                 map.put(to, -people);
//                 stops.add(to);
//             } else {
//                 map.put(to, map.get(to) - people);
//             }
//         }
        
//         Collections.sort(stops);
//         int pic = 0;
//         for(int stop: stops){
//             int delta = map.get(stop);
//             pic += delta;
            
//             if(pic > capacity){
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }

class Solution {
    
    class Pair implements Comparable<Pair> {
        int time;
        int delta;
        
        Pair(int time, int delta){
            this.time = time;
            this.delta = delta;
        }
        
        public int compareTo(Pair o){
            if(this.time != o.time){
                return this.time - o.time;
            } else {
                if(this.delta < 0){
                    return -1;
                } else if(o.delta < 0){
                    return +1;
                } else {
                    return 0;
                }
            }
        }
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
        int[] map = new int[1001];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int[] trip: trips){
            pq.add(new Pair(trip[1], +trip[0]));
            pq.add(new Pair(trip[2], -trip[0]));
        }
        
        int pic = 0;
        while(pq.size() > 0){
            Pair rem = pq.remove();
            pic += rem.delta;
            
            if(pic > capacity){
                return false;
            } else if(pic < 0){
                pic = 0;
            }
        }
        
        return true;
    }
}