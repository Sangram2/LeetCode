class Solution {
    public String longestPrefix(String s) {
        int i = 1;
        int len = 0;
        int[] lps = new int[s.length()];
        
        while(i<s.length()){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = len+1;
                len++;
                i++;
            }
            else if(len == 0){
                lps[i] = 0;
                i++;
            }
            else{
                len = lps[len-1];
            }
        }
        int k = lps[s.length()-1];
        return s.substring(0,k);
    }
}