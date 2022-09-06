class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         String s1 = process(s);
//         String s2 = process(t);
       
//         if(s1.equals(s2)){
//             return true;
//         }
//         else{
//             return false;   
//         }
//     }
    
//     String process(String s){
//         Stack<Character> st = new Stack<>();
        
//         for(int i = 0;i<s.length();i++){
//             char ch = s.charAt(i);
//             if(ch == '#' && st.size()>0){
//                 st.pop();
//             }
//             else if(ch!='#'){
//                st.push(ch); 
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         while(st.size()>0){
//             char ch = st.pop();
//             sb.append(ch);
//         }
//         return sb.toString();
//     }
    
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
}