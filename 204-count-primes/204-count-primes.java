class Solution {
    public int countPrimes(int n) {
        if(n==0|| n==1){
            return 0;
        }
        boolean[] arr = new boolean[n];
        arr[0] = arr[1] = true;
        
        for(int i=2;i*i<=n;i++){
            if(arr[i]){
                continue;
            }
            else{
                for(int mul=2;mul*i<n;mul++){
                    arr[mul*i] = true;
                }
            }
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==false){
                count++;
            }
        }
        return count;
        
    }
}