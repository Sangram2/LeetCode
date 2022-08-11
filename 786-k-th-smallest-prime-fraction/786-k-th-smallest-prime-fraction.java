class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0.0;
        double hi = 1.0;
        
        while(lo<=hi){
            double mid = lo+(hi-lo)/2;
            int p = 0;
            int q = 1;
            int count = 0;
            int j = 1;
            for(int i =0;i<arr.length;i++){
                while(j<arr.length && arr[i]>mid*arr[j]){
                    j++;
                }
                if(j==arr.length){
                    break;
                }
                if(p*arr[j]<arr[i]*q){
                    p = arr[i];
                    q = arr[j];
                }
                count += arr.length-j;
            }
            if(count<k){
                lo = mid;
            }
            else if(count>k){
                hi = mid;
            }
            else{
                return new int[]{p,q};
            }
        }
        return new int[]{1,1};
    }
}