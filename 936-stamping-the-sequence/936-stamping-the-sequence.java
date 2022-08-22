class Solution {
    public int[] movesToStamp(String stamp, String target) {
        List<Integer> reverseList = new ArrayList<>();
        char[] targetStr = new char[target.length()];
        char[] curr = target.toCharArray();
        Arrays.fill(targetStr,'*');
        
        while(!Arrays.equals(curr,targetStr)){
            int stampIdx = getStIdx(curr,stamp);
            if(stampIdx<0){
                return new int[0];
            }
            else{
                update(curr,stamp,stampIdx);
            }
            
            reverseList.add(stampIdx);
        }
        
        int[] ans = new int[reverseList.size()];
        int idx = 0;
        for(int i = ans.length-1;i>=0;i--){
            ans[idx++] = reverseList.get(i);
        }
        return ans;
        
        
    }
    
    int getStIdx(char[] curr,String stamp){
        for(int i = 0;i<=curr.length-stamp.length();i++){
            int j = 0;
            int s = i;
            boolean nA = false;
            while(j<stamp.length() && s<curr.length && (curr[s] == stamp.charAt(j) || curr[s]=='*')){
                if(curr[s] != '*'){
                    nA = true;
                }
                j++;
                s++;
            }
            if(j==stamp.length() && nA){
                return  i;
            }
        }
        return -1;
    }
    
    void update(char[] curr,String stamp,int idx){
        for(int i = 0;i<stamp.length();i++){
            curr[idx+i] = '*'; 
        }
    }
}