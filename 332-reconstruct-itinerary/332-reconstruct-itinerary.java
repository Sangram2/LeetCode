// class Solution {
//     HashMap<String,PriorityQueue<String>> adj;
//     public List<String> findItinerary(List<List<String>> tickets) {
//         adj = new HashMap<>();
//         for(List<String> ticket : tickets){
//             String from = ticket.get(0);
//             String to = ticket.get(1);
//             if(!adj.containsKey(from)){
//                 adj.put(from, new PriorityQueue<>());
//             }
//             adj.get(from).add(to);
//         }
        
//         List<String> res = new ArrayList<>();
//         dfs("JFK",res);
//         return res;
//     }
    
//     void dfs(String v,List<String> res){
//         if(adj.containsKey(v)==false || adj.get(v).size()==0){
//             res.add(0,v);
//             return;
            
//         }
        
//         while(adj.get(v).size()>0){
//             String newPlace = adj.get(v).remove();
//             dfs(newPlace,res);
//         }
//         res.add(0,v);
//     }

// }

class Solution {
    HashMap<String,PriorityQueue<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!adj.containsKey(from)){
                adj.put(from, new PriorityQueue<>());
            }
            adj.get(from).add(to);
        }
        
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK",res);
        return res;
    }
    
    void dfs(String v,LinkedList<String> res){
        if(adj.containsKey(v)==false || adj.get(v).size()==0){
            res.addFirst(v);
            return;
            
        }
        
        while(adj.get(v).size()>0){
            String newPlace = adj.get(v).remove();
            dfs(newPlace,res);
        }
        res.addFirst(v);
    }

}