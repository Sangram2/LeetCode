class Solution {
    int[] parent;
    int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        for(List<Integer> pair : pairs){
            int il = find(pair.get(0));
            int jl = find(pair.get(1));
            if(il!=jl){
                union(il,jl);
            }
        }
        
        HashMap<Integer,PriorityQueue<Character>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int il = find(i);
            
            if(!hm.containsKey(il)){
                hm.put(il,new PriorityQueue<>());
            }
            hm.get(il).add(ch);
            
        }
        
        StringBuilder ans = new StringBuilder();
        for(int v : parent){
            char f = hm.get(v).remove();
            ans.append(f);
        }
        return ans.toString();
        
        
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }
    
    void union(int x,int y){
        if(rank[x]>rank[y]){
            parent[y] = x;
        }
        else if(rank[x]<rank[y]){
            parent[x] = y;
        }
        else{
            parent[x] = y;
            rank[y]++;
        }
    }
}