class Solution {
    public int kSimilarity(String s1, String s2) {
        Queue<String> qu = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        int level = 0;
        qu.add(s1);
        while(qu.size()!=0){
            int size = qu.size();
            while(size-- > 0){
                String rem = qu.remove();

                if(vis.contains(rem)){
                    continue;
                }
                vis.add(rem);
            
                if(rem.equals(s2)){
                    return level;
                }
                
                for(String str: getNeighbors(rem, s2)){
                    if(!vis.contains(str)){
                        qu.add(str);
                    }
                }
                
            }
            level++;
        }
        return -1;
    }
    public List<String> getNeighbors(String s1, String s2){
        ArrayList<String> res = new ArrayList<>();
        
        int idx = -1;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                idx = i;
                break;
            }
        }
        
        if(idx != -1){
            for(int j = idx + 1; j < s1.length(); j++){
                if(s1.charAt(j) == s2.charAt(idx)){
                    String s1dash = swap(s1, idx, j);
                    res.add(s1dash);
                }
            }
        }
        
        return res;
    }
    
    public String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);
        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);
        
        return sb.toString();
    }

}