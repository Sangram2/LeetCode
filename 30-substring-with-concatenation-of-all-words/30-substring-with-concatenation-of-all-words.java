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
// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         final Map<String, Integer> counts = new HashMap<>();
//         for (final String word : words) {
//             counts.put(word, counts.getOrDefault(word, 0) + 1);
//         }
//         final List<Integer> indexes = new ArrayList<>();
//         final int n = s.length(), num = words.length, len = words[0].length();
//         for (int i = 0; i < n - num * len + 1; i++) {
//             final Map<String, Integer> seen = new HashMap<>();
//             int j = 0;
//             while (j < num) {
//                 final String word = s.substring(i + j * len, i + (j + 1) * len);
//                 if (counts.containsKey(word)) {
//                     seen.put(word, seen.getOrDefault(word, 0) + 1);
//                     if (seen.get(word) > counts.getOrDefault(word, 0)) {
//                         break;
//                     }
//                 } else {
//                     break;
//                 }
//                 j++;
//             }
//             if (j == num) {
//                 indexes.add(i);
//             }
//         }
//         return indexes;
//     }
// }