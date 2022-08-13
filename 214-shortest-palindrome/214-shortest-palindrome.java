class Solution {
    public String shortestPalindrome(String s) {
        String str = s+"$"+ new StringBuilder(s).reverse().toString();
        int[] lps = getSP(str);
        int ppl = lps[lps.length-1];
        
        String right = s.substring(ppl);
        
        return new StringBuilder(right).reverse().toString()+s;
    }
    int[] getSP(String s){
        int i =1;
        int len =0;
        int[] lps = new int[s.length()];
        while(i<s.length()){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = len+1;
                i++;
                len++;
            }
            else if(len==0){
                lps[i] = 0;
                i++;
            }
            else{
                len = lps[len-1];
            }
        }
        return lps;
    }
}