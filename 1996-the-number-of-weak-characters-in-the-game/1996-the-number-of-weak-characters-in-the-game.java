
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // sorting 
        Arrays.sort(properties,(a,b)->{
           if(a[0]!=b[0]){
               return a[0]-b[0];
           } 
           else{
                return b[1]-a[1];
           }
        });
        int count = 0;
        int max = -1;
        for(int i = properties.length-1;i>=0;i--){
            int def = properties[i][1];
            if(def<max){
                count++;
            }
            else{
                max = def;
            }
        }
        return count;
        
        
    }
}
