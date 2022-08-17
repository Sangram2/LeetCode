class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hs = new HashSet<>();
        String[] ref = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String w:words){
            String part = "";
            for(int i=0;i<w.length();i++){
                part+=ref[w.charAt(i)-'a'];
            }
            hs.add(part);
        }
       return hs.size(); 
    }
}