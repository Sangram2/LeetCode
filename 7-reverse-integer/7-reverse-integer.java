class Solution {
    public int reverse(int x) {
        boolean p = true;
        if(x<0){
            p = false;
        }
        
        long j = 0L;
        x = Math.abs(x);
        while(x!=0 && x%10==0){
            x/=10;
        }
        while(x>0){
            
            int rem = x%10;
            j = 10*j+(long)rem;
            x/=10;
        }
        int a = Integer.MAX_VALUE;
        int c = Integer.MIN_VALUE;
        
        if(p){
            if(j>(long)a){
                return 0;
            }
            return (int)j;
        }
        else{
            j = -j;
            if(j<(long)c){
                return 0;
            }
            return (int)j;
        }
    }
}