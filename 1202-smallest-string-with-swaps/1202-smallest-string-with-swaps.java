// class Solution {
//     int[] parent;
//     int[] rank;
//     public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//         int n = s.length();
//         parent = new int[n];
//         rank = new int[n];
//         for(int i=0;i<n;i++){
//             parent[i] = i;
//         }
        
//         for(List<Integer> pair : pairs){
//             int il = find(pair.get(0));
//             int jl = find(pair.get(1));
//             if(il!=jl){
//                 union(il,jl);
//             }
//         }
        
//         HashMap<Integer,PriorityQueue<Character>> hm = new HashMap<>();
//         for(int i=0;i<n;i++){
//             char ch = s.charAt(i);
//             int il = find(i);
            
//             if(!hm.containsKey(il)){
//                 hm.put(il,new PriorityQueue<>());
//             }
//             hm.get(il).add(ch);
            
//         }
        
//         StringBuilder ans = new StringBuilder();
//         for(int v : parent){
//             char f = hm.get(v).remove();
//             ans.append(f);
//         }
//         return ans.toString();
        
        
//     }
    
//     int find(int x){
//         if(parent[x] == x){
//             return x;
//         }
//         else{
//             return parent[x] = find(parent[x]);
//         }
//     }
    
//     void union(int x,int y){
//         if(rank[x]>rank[y]){
//             parent[y] = x;
//         }
//         else if(rank[x]<rank[y]){
//             parent[x] = y;
//         }
//         else{
//             parent[x] = y;
//             rank[y]++;
//         }
//     }
// }
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(List<Integer> pair: pairs){
            int i = pair.get(0);
            int j = pair.get(1);
            
            int il = find(i);
            int jl = find(j);
            if(il != jl){
                union(il, jl);
            }
        }
        
        PriorityQueue<Character>[] pqs = new PriorityQueue[s.length()];
        for(int i = 0; i < pqs.length; i++){
            pqs[i] = new PriorityQueue<>();
        }
        
        for(int i = 0; i < s.length(); i++){
            int il = find(i);
            char ch = s.charAt(i);
            pqs[il].add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int il = find(i);
            char ch = pqs[il].remove();
            sb.append(ch);
        }
        
        return sb.toString();
    }
    int[] parent;
    int[] rank;
    
    void union(int x, int y){
        if(rank[x] < rank[y]){
            parent[x] = y;
        } else if(rank[y] < rank[x]){
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}