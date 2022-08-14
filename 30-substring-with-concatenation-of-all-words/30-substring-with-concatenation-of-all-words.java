class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> copy = new HashMap<>();
        int n = words[0].length();
        int m = words.length;
        if(s.length()<m*n){
            return new ArrayList<>();
        }
        
        for(String w:words){
            copy.put(w,copy.getOrDefault(w,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        
        
        
        int i = 0;
        while(i<=(s.length()-(n*words.length))){
           String key = s.substring(i,i+n);
            
            if(copy.containsKey(key)){
                int j = i+n;
                
                while(copy.containsKey(key)){
                    
                    copy.put(key,copy.get(key)-1);
                    if(copy.get(key)==0){
                        copy.remove(key);
                    }
                    key = s.substring(j,Math.min(s.length(),(j+n)));
                    
                    j = j+n;
                }
                
                
                if(copy.size()==0){
                    ans.add(i);
                    i++;
                    
                    for(String w:words){
                        copy.put(w,copy.getOrDefault(w,0)+1);
                    }
                    
                }
                else{
                    
                    
                    copy = new HashMap<>();
                    for(String w:words){
                        copy.put(w,copy.getOrDefault(w,0)+1);
                    }
                    i++;
                }
                
                
            }
            
            
            else{
                i++;
            }
        }
        return ans;
        
    }
}
