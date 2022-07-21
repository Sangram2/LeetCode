class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int j = -1;
        int i=0;
        for(i=0;i<seats.length;i++){
            if(seats[i]==1){
                if(j==-1){
                    j=i;
                    res = Math.max(res,j);
                    
                    
                }else{
                    res = Math.max((i-j)/2,res);
                    j=i;
                }
            }
        }
        
        res = Math.max(i-j-1,res);
        
        
        return res;
    }
}