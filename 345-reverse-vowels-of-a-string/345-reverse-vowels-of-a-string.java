class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = s.length()-1;
        String vowels = "aeiouAEIOU";
        while(i<j){
            while(i<j && vowels.indexOf(sb.charAt(i))==-1){
                i++;
            }
            while(i<j && vowels.indexOf(sb.charAt(j))==-1){
                j--;
            }
            
            char temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,temp);
            i++;
            j--;
        }
        
        return sb.toString();
    }
}