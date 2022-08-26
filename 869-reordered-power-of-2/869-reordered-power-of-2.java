class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] arr = count(n);
        int i = 1;
        for(int j=1;j<31;j++){
            int[] y = count(i);
            if(Arrays.equals(y,arr)){
                return true;
            }
            i *= 2; 
        }
            
           
        
        return false;
    }
    
    int[] count(int n){
        int[] arr = new int[10];
        int j = n;
        while(j>0){
            arr[j%10]++;
            
            j = j/10;
            
        }
        return arr;
    }
}