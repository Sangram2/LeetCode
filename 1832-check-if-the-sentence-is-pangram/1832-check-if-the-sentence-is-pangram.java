class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] check = new boolean[26];
        for(int i = 0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            check[ch-'a'] = true;
        }
        for(int i = 0;i<26;i++){
            if(check[i] == false){
                return false;
            }
        }
        return true;
    }
}