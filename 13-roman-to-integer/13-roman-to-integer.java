class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int prev = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        for(int i = s.length()-1;i>=0;i--){
            char rc = s.charAt(i);
            int val = hm.get(rc);
            if(val>=prev){
                ans+=val;
            }
            else{
                ans-=val;
            }
            prev = val;
        }
        return ans;
    }
}