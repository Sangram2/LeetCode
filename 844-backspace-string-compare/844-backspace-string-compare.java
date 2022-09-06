class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = process(s);
        String s2 = process(t);
       
        if(s1.equals(s2)){
            return true;
        }
        else{
            return false;   
        }
    }
    
    String process(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '#' && st.size()>0){
                st.pop();
            }
            else if(ch!='#'){
               st.push(ch); 
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            char ch = st.pop();
            sb.append(ch);
        }
        return sb.toString();
    }
}