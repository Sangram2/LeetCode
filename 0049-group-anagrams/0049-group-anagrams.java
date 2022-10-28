class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     HashMap<String,ArrayList<String>> hm = new HashMap<>();
    //     for(String s : strs){
    //         String h = solve(S);
    //         if(hm.containsKey(h)){
    //             hm.put(h,new ArrayList<>());
    //             hm.get(h).add(s);
    //         }
    //         else{
    //             hm.put()
    //         }
    //     }
    // }
     public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
   