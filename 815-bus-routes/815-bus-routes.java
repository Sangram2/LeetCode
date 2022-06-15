class Solution {
    class pair{
        int bus;
        int count;
        pair(int bus,int count){
            this.bus=bus;
            this.count=count;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
       if(source==target){
           return 0;
           
       } 
        
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        
        for(int bus=0;bus<routes.length;bus++){
            for(int stop : routes[bus]){
                if(!hm.containsKey(stop)){
                    hm.put(stop,new ArrayList<>());
                }
                hm.get(stop).add(bus);
            }
        }
        
        boolean[] vis = new boolean[routes.length];
        Queue<pair> qu = new LinkedList<>();
        for(int bus:hm.get(source)){
            qu.add(new pair(bus,1));
        }
        while(qu.size()!=0){
           pair rem=qu.remove();
            if(vis[rem.bus]){
                continue;
            }
            
            vis[rem.bus]=true;
            
            for(int stop:routes[rem.bus]){
                if(stop==target){
                    return rem.count;
                }
            }
            
             for(int stop: routes[rem.bus]){
                for(int nbus: hm.get(stop)){
                    if(vis[nbus] == false){
                        qu.add(new pair(nbus, rem.count + 1));
                    }
                }
            }
        }
        return -1;
    }
}