class Solution {
    int[] parent;
    int[] rank;
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
            rank[i] = 0;
            
        }
        for(String eqn : equations){
            if(eqn.charAt(1)=='='){
                int w0L = find(eqn.charAt(0)-'a');
                int w1L = find(eqn.charAt(3)-'a');
                
                if(w0L != w1L){
                    union(w0L,w1L);
                }
            }
        }
        for(String eqn : equations){
            if(eqn.charAt(1)=='!'){
                int w0L = find(eqn.charAt(0)-'a');
                int w1L = find(eqn.charAt(3)-'a');
                
                if(w0L == w1L){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int sl1,int sl2){
        if(rank[sl1] > rank[sl2]){
            parent[sl2] = sl1;
        }
        else if(rank[sl1] < rank[sl2]){
            parent[sl1] = sl2;
        }
        else{
            parent[sl1] = sl2;
            rank[sl2]++;
        }
    }
}