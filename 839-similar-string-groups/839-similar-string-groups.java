class Solution {
    int []parent;
    int[]rank;
    public int numSimilarGroups(String[] strs) {
        parent = new int[strs.length];
        rank = new int[strs.length];
        
        for(int i = 0;i<strs.length;i++){
            parent[i] = i;
            rank[i] = 0;
        } 
        
        for(int i=0;i<strs.length-1;i++){
            for(int j=i+1;j<strs.length;j++){
                String a = strs[i];
                String b = strs[j];
                if(areSimilar(a,b)){
                    unionHelper(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i){
                count++;
            }
        }
        return count;
    }
    
    boolean areSimilar(String s1,String s2){
        int c = 0;
        for(int i=0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1!=c2){
                c++;
            }
        }
        return c==0 || c==2;
    }
    void unionHelper(int a,int b){
        if(find(a)!=find(b)){
            union(find(a),find(b));
        }
    }
    
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    void union(int x,int y){
        if(rank[x]<rank[y]){
            parent[x]=y;
        }
        else if(rank[x]>rank[y]){
            parent[y] = x;
        }
        else{
            parent[x]=y;
            rank[y]++;
        }
    }
}