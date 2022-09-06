class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        for(char ch:arr){
            freq[ch-'a']++;
        }
        boolean[] check = new boolean[26];
        
        Stack<Character> st = new Stack<>();
        for(char ch: arr){
            freq[ch-'a']--;
            if(check[ch-'a']){
                continue;
            }
            while(st.size()>0 && freq[st.peek()-'a']>0 && ch<st.peek()){
                check[st.pop()-'a'] = false;
            }
            
                
            if(!check[ch-'a']){
                st.push(ch);
                check[ch-'a'] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}