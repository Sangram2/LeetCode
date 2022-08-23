class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<=pattern.length();i++){
            sb.append((char)('1'+i));
            
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                res.append(sb.reverse());
                sb = new StringBuilder();
            }
        }
        
        return res.toString();
    }
}