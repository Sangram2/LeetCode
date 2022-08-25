class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        for(int i = 0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(!hm.containsKey(c) || hm.get(c)<=0){
                return false;
            }
            else{
                hm.put(c,hm.get(c)-1);
            }
        }
        return true;
    }
}