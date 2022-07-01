// class Solution {
//     int []parent;
//     int[]rank;
//     public int numSimilarGroups(String[] strs) {
//         parent = new int[strs.length];
//         rank = new int[strs.length];
        
//         for(int i = 0;i<strs.length;i++){
//             parent[i] = i;
//             rank[i] = 0;
//         } 
        
//         for(int i=0;i<strs.length-1;i++){
//             for(int j=i+1;j<strs.length;j++){
//                 String a = strs[i];
//                 String b = strs[j];
//                 if(areSimilar(a,b)){
//                     unionHelper(i,j);
//                 }
//             }
//         }
//         int count=0;
//         for(int i=0;i<parent.length;i++){
//             if(parent[i]==i){
//                 count++;
//             }
//         }
//         return count;
//     }
    
//     boolean areSimilar(String s1,String s2){
//         int c = 0;
//         for(int i=0;i<s1.length();i++){
//             char c1 = s1.charAt(i);
//             char c2 = s2.charAt(i);
//             if(c1!=c2){
//                 c++;
//             }
//         }
//         return c==0 || c==2;
//     }
//     void unionHelper(int a,int b){
//         if(find(a)!=find(b)){
//             union(find(a),find(b));
//         }
//     }
    
//     int find(int x){
//         if(parent[x]==x){
//             return x;
//         }
//         else{
//             parent[x] = find(parent[x]);
//             return parent[x];
//         }
//     }
//     void union(int x,int y){
//         if(rank[x]<rank[y]){
//             parent[x]=y;
//         }
//         else if(rank[x]>rank[y]){
//             parent[y] = x;
//         }
//         else{
//             parent[x]=y;
//             rank[y]++;
//         }
//     }
// }

class Solution {
    public int numSimilarGroups(String[] strs) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for(String str: strs){
            parent.put(str, str);
            rank.put(str, 1);
        }
        
        for(int i = 0; i < strs.length; i++){
            for(int j = i + 1; j < strs.length; j++){
                String si = strs[i];
                String sj = strs[j];
                
                if(areSimilar(si, sj)){
                    String li = find(si);
                    String lj = find(sj);
                    
                    if(li.equals(lj) == false){
                        union(li, lj);
                    }
                }
            }
        }
        
        int count = 0;
        for(String key: parent.keySet()){
            if(parent.get(key).equals(key)){
                count++;
            }
        }
        
        return count;
    }
    
    boolean areSimilar(String x, String y){
        int res = 0;
        
        for(int i = 0; i < x.length(); i++){
            if(x.charAt(i) != y.charAt(i)){
                res++;
            }
        }
        
        return res == 2 ;
    }
    
    HashMap<String, String> parent;
    HashMap<String, Integer> rank;
    
    String find(String x){
        if(parent.get(x).equals(x)){
            return x;
        } else {
            String pox = parent.get(x);
            String lead = find(pox);
            
            parent.put(x, lead);
            
            return lead;
        }
    }
    
    void union(String x, String y){
        if(rank.get(x) < rank.get(y)){
            parent.put(x, y);
        } else if(rank.get(y) < rank.get(x)){
            parent.put(y, x);
        } else {
            parent.put(y, x);
            rank.put(x, rank.get(x) + 1);
        }
    }
}