class Solution {
    public int longestIdealString(String s, int k) {
        int[] len = new int[26];
        
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            int max = 0;
            int f = ch-'a';
            
            for(int j = (-k);j<=k;j++){
                
                if(f+j<0 || f+j>25){
                    
                    continue;
                }
                
                int pos = f+j;
                int li = len[pos];
                max = Math.max(max,li);
            }
            
            len[ch-'a'] = max+1;
            
        }
        int max = 1;
        for(int ele:len){
            max = Math.max(ele,max);
        }
        return max;
    } 
}