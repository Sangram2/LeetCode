class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char b = s.charAt(i);
            if(b == '('){
                st.push(b);
            }
            else{
                if(st.size()>0 && st.peek() == '('){
                    st.pop();
                }else{
                    st.push(b);
                }
            }
        }
        
        return st.size();
    }
}