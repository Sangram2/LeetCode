class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            map[ch-'a'] = i;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int beg = 0;
        int en = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            en = Math.max(map[ch-'a'],en);
            
            if(i==en){
                int len = en-beg+1;
                ans.add(len);
                en = beg = i+1;
            }
            
        }
        return ans;
    }
}