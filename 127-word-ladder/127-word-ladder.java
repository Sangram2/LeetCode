class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> hs = new HashSet<>();
        for(String w:wordList){
            hs.add(w);
        }
        
        if(!hs.contains(endWord)){
            return 0;
        }
        
        Queue<String> qu = new LinkedList<>();
        
        qu.add(beginWord);
        int depth = 1;
        while(qu.size()!=0){
            int size = qu.size();
            while((size--)>0){
                String s = qu.remove();
                for(int i = 0;i<s.length();i++){
                    String lp = s.substring(0,i);
                    String rp = s.substring(i+1,s.length());
                    for(int j =0;j<26;j++){
                        char ch = (char)('a'+j);
                        String str = lp+ch+rp;
                        if(str.equals(endWord)){
                            return depth+1;
                        }
                        if(hs.contains(str)){
                            hs.remove(str);
                            qu.add(str);
                        }
                    }
                }
            }
            depth++;
        }
        return 0;
    }
}