class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }
        int n = palindrome.length();
        boolean fa = true;
        StringBuilder sb = new StringBuilder(palindrome);
        for(int i = 0;i<n/2;i++){
            if(sb.charAt(i) == 'a'){
                
                continue;
            }
            else{
                fa = false;
                char ch = sb.charAt(i);
                
                sb.setCharAt(i,'a');
                break;
            }
        }
        char cj = sb.charAt(((n+1)/2)-1);
        if(fa && cj != 'a'){
            sb.setCharAt(n-1,'b');
        }
        else if(fa && cj =='a'){
            sb.setCharAt(n-1,'b');
        }
        String s = sb.toString();
        if(s.equals(palindrome)){
            return "";
        }
        else{
            return s;
        }
    }
}